package ejercicio3.main;

import java.util.Scanner;

import ejercicio3.acceso.DatosBBDD;
import ejercicio3.model.Autor;
import ejercicio3.model.Libro;

public class InsertarDatos {

	public static void main(String[] args) {
		DatosBBDD datos = new DatosBBDD();
		int res = 0;
		Scanner sc = new Scanner(System.in);
		String nombre;
		String nacionalidad;
		Autor autor = null;
		int idAutor = 0;
		String titulo;
		int numPag = 0, anioE = 0;
		Libro libro = null;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Introduce el nombre del autor: ");
			nombre = sc.nextLine();
			
			System.out.println("La nacionalidad: ");
			nacionalidad = sc.nextLine();
			
			autor = new Autor(nombre, nacionalidad);
			
			idAutor = datos.insertarAutor(autor);
			
			if (idAutor > 0) {
				System.out.println("*** El autor se ha insertado correctamente ***");
			}
			autor.setId(idAutor);
			
			for (int j = 0; j < 2; j++) {
				System.out.println("Introduce el titulo del libro: ");
				titulo = sc.nextLine();
				
				System.out.println("El número de páginas: ");
				numPag = Integer.parseInt(sc.nextLine());
				
				System.out.println("El año de edición: ");
				anioE = Integer.parseInt(sc.nextLine());
				
				libro = new Libro(titulo, numPag, anioE, autor);
				res = datos.insertarLibro(libro);
				
				if (res == 0) {
					System.out.println("*** El libro se ha insertado correctamente ***");
				}
				
				
			}
			
		}
		
		sc.close();

	}

}
