package ejercicio3.main;

import java.util.ArrayList;

import ejercicio3.acceso.DatosBBDD;
import ejercicio3.model.Autor;
import ejercicio3.model.Libro;

public class ConsutarDatos {

	public static void main(String[] args) {
		DatosBBDD datos = new DatosBBDD();
		
		ArrayList<Libro> listaLibros = datos.getListadoLibros();
		System.out.println("Lista de libros: ");
		for (Libro libro : listaLibros) {
			System.out.println("T�tulo: " + libro.getTitulo() + "\nN�mero de p�ginas: " + libro.getNumPag() 
								+ "\nA�o de edici�n: " + libro.getAnioEdic() 
								+ "\nAutor: " + libro.getAutor().getNombre() + " (" + libro.getAutor().getNacionalidad() + ")");
			
		}
		
		System.out.println();
		listaLibros = datos.getListadoLibrosG();
		System.out.println("Lista de libros con m�s de 600 p�ginas: ");
		for (Libro libro : listaLibros) {
			System.out.println("T�tulo: " + libro.getTitulo() + "\nN�mero de p�ginas: " + libro.getNumPag() 
								+ "\nA�o de edici�n: " + libro.getAnioEdic() 
								+ "\nAutor: " + libro.getAutor().getNombre() + " (" + libro.getAutor().getNacionalidad() + ")");
			
		}

		Autor autor = datos.getAutorLibroMasPaginas();
		System.out.println("Autor del libro con m�s p�ginas: ");
		System.out.println(autor.getNombre() + " (" + autor.getNacionalidad() + ")");
			
	}

}
