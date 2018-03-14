package ejercicio3.model;

public class Libro {
	private int id;
	private String titulo;
	private int numPag;
	private int anioEdic;
	private Autor autor;
	
	public Libro() {}

	public Libro(String titulo, int numPag, int anioEdic, Autor autor) {
		this.titulo = titulo;
		this.numPag = numPag;
		this.anioEdic = anioEdic;
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getNumPag() {
		return numPag;
	}
	
	public int getAnioEdic() {
		return anioEdic;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public void setAnioEdic(int anioEdic) {
		this.anioEdic = anioEdic;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	
}
