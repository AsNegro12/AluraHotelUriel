package mx.com.aluraHotel.pruebas;

import mx.com.aluraHotel.Controller.ReservasController;

public class PruebaEliminarPorIDReserva
{
	public static void main(String[] args)
	{
		ReservasController controller = new ReservasController();
		
		String id = "5";
		
		controller.eliminarId(id);
		
		System.out.println("Se elimino el registro de huesped");
	}
}
