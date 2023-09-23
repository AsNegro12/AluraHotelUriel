package mx.com.aluraHotel.modelo;

import java.sql.Date;

public class Huespedes
{
	private Long id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiendo;
	private String nacionalidad;
	private String telefono;
	private Long idReserva;
	
	public Huespedes
	(String nombre, String apellido, Date fechaNacimiendo, String nacionalidad, String telefono, Long idReserva)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiendo = fechaNacimiendo;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public Huespedes
	(Long id, String nombre, String apellido, Date fechaNacimiendo, String nacionalidad, String telefono, Long idReserva)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiendo = fechaNacimiendo;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiendo() {
		return fechaNacimiendo;
	}

	public void setFechaNacimiendo(Date fechaNacimiendo) {
		this.fechaNacimiendo = fechaNacimiendo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public String toString() {
		return "Huespedes [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiendo="
				+ fechaNacimiendo + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", idReserva="
				+ idReserva + "]";
	}

}
