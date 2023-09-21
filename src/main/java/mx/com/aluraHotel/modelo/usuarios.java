package mx.com.aluraHotel.modelo;

public class usuarios
{
	private Long id;
	private String nombre;
	private String clave;
	
	
	public usuarios(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}


	public usuarios(Long id, String nombre, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
