package ejercicio2;

import java.io.*;

public class InsertLibrosObj {

	public static void main(String[] args) {
		
		String[] libros = {"El señor de los anillos", "El clan del oso cavernario", "El ocho"};
		int[] numPag = {1368, 564, 624};
		int[] anios = {1978, 1980, 1988};
		String[] autores = {"J.R.R.Tolkien", "Jean Marie Auel", "Katherine Neville"};
		String[] nacionalidades = {"Sudafricano", "Estadounidense", "Estadounidense"};
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("biblioteca.dat"));
			
			Autor autor = null;
			for (int i = 0; i < autores.length; i++) {
				autor = new Autor(autores[i], nacionalidades[i]);
				oos.writeObject(new Libro(libros[i], autor, numPag[i], anios[i]));
			}
			
			ois = new ObjectInputStream(new FileInputStream("biblioteca.dat"));
			Libro lp = null;

			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}

}
