package mx.com.aluraHotel.pruebas;

import java.util.List;

import mx.com.aluraHotel.Controller.ReservasController;
import mx.com.aluraHotel.modelo.Reserva;

public class PuebaListarReservas
{
	public static void main(String[] args)
	{
		ReservasController controller = new ReservasController();
		
		List<Reserva> listar = controller.ListarReservas();
		for(Reserva reserva: listar)
		{
			System.out.println(reserva);
		}
	}
}
