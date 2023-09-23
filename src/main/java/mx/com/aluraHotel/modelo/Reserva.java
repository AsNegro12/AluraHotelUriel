package mx.com.aluraHotel.modelo;

import java.sql.Date;

public class Reserva
{
	private Long id;
	private Date fecha_entrada;
	private Date fecha_salida;
	private String valor;
	private String formato_pago;
	
	public Reserva(Date fecha_entrada, Date fecha_salida, String valor, String formato_pago) {
		super();
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.valor = valor;
		this.formato_pago = formato_pago;
	}

	public Reserva(Long id, Date fecha_entrada, Date fecha_salida, String valor, String formato_pago) {
		super();
		this.id = id;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.valor = valor;
		this.formato_pago = formato_pago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormato_pago() {
		return formato_pago;
	}

	public void setFormato_pago(String formato_pago) {
		this.formato_pago = formato_pago;
	}
	
}
