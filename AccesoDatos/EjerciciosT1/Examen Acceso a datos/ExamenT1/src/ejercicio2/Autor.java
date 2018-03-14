package ejercicio2;


import java.io.Serializable;

public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1426111633987671954L;
	private String nombre;
	private String nacionalidad;
	
	public Autor(String nombre, String nacionalidad) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	
}
