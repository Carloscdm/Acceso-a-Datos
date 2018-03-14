package ejercicio2;


import java.io.Serializable;

public class Libro implements Serializable{
	
	private static final long serialVersionUID = -2621930855385763215L;
	
	private String titulo;
	private Autor autor;
	private int numPag;
	private int anioPub;
	
	public Libro(String titulo, Autor autor, int numPag, int anioPub) {
		this.titulo = titulo;
		this.autor = autor;
		this.numPag = numPag;
		this.anioPub = anioPub;
	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public int getNumPag() {
		return numPag;
	}

	public int getAnioPub() {
		return anioPub;
	}
	
	
}
