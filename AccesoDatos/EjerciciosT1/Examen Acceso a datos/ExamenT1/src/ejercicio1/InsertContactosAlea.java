package ejercicio1;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class InsertContactosAlea {

	static final int TAM_NOMBRE = 30;
	static final int TAM_TELEFONO = 12;
	static final int TAM_EMAIL = 30;
	static final int TAM_FECHA = 10;
	static final int TAM_REGISTRO = 168; // 4 + 60 + 24 + 60 + 20
	
	public static void main(String[] args) {
		RandomAccessFile raf = null;
		Scanner sc = new Scanner(System.in);
		try {
			raf = new RandomAccessFile("contactos.dat", "rw");
			
			int id = 0;
			if (raf.length() > 0) {
				raf.seek(raf.length() - TAM_REGISTRO);
				id = raf.readInt();
			}
			
			raf.seek(raf.length());
			
			raf.writeInt(id + 1);
			
			System.out.println("Introduce el nombre:");
			StringBuffer sbn = new StringBuffer(sc.nextLine());
			sbn.setLength(TAM_NOMBRE); 
			raf.writeChars(sbn.toString());
			
			System.out.println("Introduce el teléfono:");
			StringBuffer sbt = new StringBuffer(sc.nextLine());
			sbt.setLength(TAM_TELEFONO); 
			raf.writeChars(sbt.toString());
			
			System.out.println("Introduce el email:");
			StringBuffer sbe = new StringBuffer(sc.nextLine());
			sbe.setLength(TAM_EMAIL); 
			raf.writeChars(sbe.toString());
			
			System.out.println("Introduce la fecha de nacimiento: (dd/mm/aaaa)");
			StringBuffer sbf = new StringBuffer(sc.nextLine());
			sbf.setLength(TAM_FECHA); 
			raf.writeChars(sbf.toString());
				
			//nos situamos al principio
			raf.seek(0);
			
			char[] cNombre = new char[TAM_NOMBRE];
			String nombre;
			char[] cTelefono = new char[TAM_TELEFONO];
			String telefono;
			char[] cEmail = new char[TAM_EMAIL];
			String email;
			char[] cFecha = new char[TAM_FECHA];
			String fecha;
				
			try {
				while (raf.getFilePointer() <= raf.length()) {
					id = raf.readInt();
					
					for (int i = 0; i < TAM_NOMBRE; i++) {
						cNombre[i] = raf.readChar();
					}
					nombre = new String(cNombre);
					
					for (int i = 0; i < TAM_TELEFONO; i++) {
						cTelefono[i] = raf.readChar();
					}
					telefono = new String(cTelefono);
					
					for (int i = 0; i < TAM_EMAIL; i++) {
						cEmail[i] = raf.readChar();
					}
					email = new String(cEmail);
					
					for (int i = 0; i < TAM_FECHA; i++) {
						cFecha[i] = raf.readChar();
					}
					fecha = new String(cFecha);
					
					
					System.out.println("ID: " + id + " Nombre: " + nombre + " Teléfono: " + telefono 
							+ "\nEmail: " + email + " Fecha de Nacimiento: " + fecha);
					
				}
			} catch (EOFException e) {
				System.out.println("FICHERO LEIDO");
			} 
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			sc.close();
		}

	}

}
