package mx.com.aluraHotel.Controller;

import java.util.List;

import mx.com.aluraHotel.dao.ReservasDAO;
import mx.com.aluraHotel.modelo.Huespedes;
import mx.com.aluraHotel.modelo.Reserva;

public class ReservasController
{
	private ReservasDAO reservadao;
	
	public ReservasController()
	{
		reservadao = new ReservasDAO();
	}
	
	public void guardar(Reserva reserva)
	{
		reservadao.guardarReserva(reserva);
	}
	
	public List<Reserva> ListarReservas()
	{
		return this.reservadao.ListarReservas();
	}
	
	public List<Reserva> listarReservaPorID(String id)
	{
		return this.reservadao.burcarPorId(id);
	}
	
	public boolean existeID(String id)
	{
		return this.reservadao.ExisteID(id);
	}
}
