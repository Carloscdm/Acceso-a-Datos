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
			System.out.println("Título: " + libro.getTitulo() + "\nNúmero de páginas: " + libro.getNumPag() 
								+ "\nAño de edición: " + libro.getAnioEdic() 
								+ "\nAutor: " + libro.getAutor().getNombre() + " (" + libro.getAutor().getNacionalidad() + ")");
			
		}
		
		System.out.println();
		listaLibros = datos.getListadoLibrosG();
		System.out.println("Lista de libros con más de 600 páginas: ");
		for (Libro libro : listaLibros) {
			System.out.println("Título: " + libro.getTitulo() + "\nNúmero de páginas: " + libro.getNumPag() 
								+ "\nAño de edición: " + libro.getAnioEdic() 
								+ "\nAutor: " + libro.getAutor().getNombre() + " (" + libro.getAutor().getNacionalidad() + ")");
			
		}

		Autor autor = datos.getAutorLibroMasPaginas();
		System.out.println("Autor del libro con más páginas: ");
		System.out.println(autor.getNombre() + " (" + autor.getNacionalidad() + ")");
			
	}

}
