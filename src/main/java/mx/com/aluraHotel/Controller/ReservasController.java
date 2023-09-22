package mx.com.aluraHotel.Controller;

import mx.com.aluraHotel.dao.ReservasDAO;
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
}
