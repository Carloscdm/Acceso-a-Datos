package ejercicio4;

public class Contacto {
	
	private Integer codigo; 
	private String nombre; 
	private String telefono; 
	private String email; 
	private String grupo;
	
	
	public Contacto() {}

	public Contacto(Integer codigo, String nombre, String telefono, String email, String grupo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.grupo = grupo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	

}
