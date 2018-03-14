package ejercicio2;


import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXMLBiblioteca {

	public static void main(String[] args) {
		
		ObjectInputStream ois = null;
		FileInputStream fis = null; 
		
		try {
			ois = new ObjectInputStream(new FileInputStream("biblioteca.dat"));
			Libro lp = null;
			
			// crearemos una instancia de DocumentBuilderFactory para construir el parser
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			DOMImplementation implementacion = db.getDOMImplementation();
			
			// Creamos un documento vacío de nombre doc con el nodo raíz de nombre biblioteca y asignamos la versión del XML
			Document doc = implementacion.createDocument(null, "biblioteca", null);
			doc.setXmlVersion("1.0");

			// controlamos el final del fichero controlando la excepción EOFException 
			try {
				Element libro, autor;
				//Recorreremos el fichero con los datos para que al leer cada registro pedido 
				while ((lp = (Libro) ois.readObject()) != null) {
						// Creamos el nodo <empleado> y lo añadimos al documento
						libro = doc.createElement("libro");   
						doc.getDocumentElement().appendChild(libro);
						
						crearElemento(doc, libro, "titulo", lp.getTitulo());
						
						autor = doc.createElement("autor");
						libro.appendChild(autor);
						crearElemento(doc, autor, "nombreAutor", lp.getAutor().getNombre());
						crearElemento(doc, autor, "nacionalidad", lp.getAutor().getNacionalidad());
						
						crearElemento(doc, libro, "numPaginas", Integer.toString(lp.getNumPag()));
						crearElemento(doc, libro, "anioPublicacion", Integer.toString(lp.getAnioPub()));
				}
			} catch (EOFException e) {} 
			
			// Creamos la fuente XML a partir del documento
			Source source = new DOMSource(doc);
			// Creamos el resultado en el fichero empleados.xml
			Result result = new StreamResult(new File("biblioteca.xml"));
			// Obtenemos un TransformerFactory
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// Le damos formato y realizamos la transformación del documento a fichero
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml"); 
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source,  result); 
			
			// Mostramos el documento por pantalla especificando como canal de salida el System.out
			Result console = new StreamResult(System.out);
			transformer.transform(source, console);
			
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}

	/*
	 * Recibe el documento (document), el nodo al que se va a añadir (raíz), el nombre del nodo hijo (id, nombre, dep, salario) y sus textos o valores en formato String 
	 */
	private static void crearElemento(Document doc, Element raiz, String nomElemento, String valor) {
		Element elem = doc.createElement(nomElemento);
		Text text = doc.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}

}
