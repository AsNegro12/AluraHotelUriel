package mx.com.aluraHotel.pruebas;

import java.util.List;

import mx.com.aluraHotel.Controller.HuespedesController;
import mx.com.aluraHotel.Controller.ReservasController;
import mx.com.aluraHotel.modelo.Huespedes;
import mx.com.aluraHotel.modelo.Reserva;

public class PruebaBusquedarPorId
{

	public static void main(String[] args)
	{
		/*
		 * String id = "8";
		 * 
		 * HuespedesController controller = new HuespedesController();
		 * 
		 * List<Huespedes> listar = controller.listarHuespedesPorID(id); boolean existe
		 * = controller.existeID(id);
		 * 
		 * if(existe) { for(Huespedes huespedes:listar) { System.out.println(huespedes);
		 * }
		 * 
		 * } else { System.out.println("No existe el id"); }
		 */
		
		String id = "1";
		
		ReservasController controller = new ReservasController();
		
		List<Reserva> listar = controller.listarReservaPorID(id);
		boolean existe = controller.existeID(id);
		
		if(existe)
		{
			for(Reserva reserva:listar)
			{
				System.out.println(reserva);
			}
			
		}
		else
		{
			System.out.println("No existe el id");
		}
	}

}
