package mx.com.aluraHotel.Controller;

import java.sql.Date;
import java.util.List;

import mx.com.aluraHotel.dao.HuespedesDAO;
import mx.com.aluraHotel.modelo.Huespedes;

public class HuespedesController
{
	private HuespedesDAO dao;
	
	public HuespedesController()
	{
		dao = new HuespedesDAO();
	}
	
	public void guardar(Huespedes huespedes)
	{
		this.dao.GuardarHuesped(huespedes);
	}
	
	public List<Huespedes> ListarHuespedes()
	{
		return this.dao.listaHuespedes();
	}
	
	public List<Huespedes> listarHuespedesPorID(String id)
	{
		return this.dao.burcarPorId(id);
	}
	
	public boolean existeID(String id)
	{
		return this.dao.ExisteID(id);
	}
	
	public void editarHuespedes(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Long idReserva, Long id)
	{
		this.dao.editarHuesped(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
	}
}
