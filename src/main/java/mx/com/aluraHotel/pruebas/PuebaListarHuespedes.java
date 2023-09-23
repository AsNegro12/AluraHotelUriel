package mx.com.aluraHotel.pruebas;

import java.util.List;

import mx.com.aluraHotel.Controller.HuespedesController;
import mx.com.aluraHotel.modelo.Huespedes;

public class PuebaListarHuespedes
{
	public static void main(String[] args)
	{
		HuespedesController controller = new HuespedesController();
		
		List<Huespedes> listar = controller.ListarHuespedes();
		for(Huespedes huespedes: listar)
		{
			System.out.println(huespedes);
		}
	}
}
