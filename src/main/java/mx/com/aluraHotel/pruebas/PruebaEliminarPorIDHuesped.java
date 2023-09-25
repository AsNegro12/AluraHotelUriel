package mx.com.aluraHotel.pruebas;

import mx.com.aluraHotel.Controller.HuespedesController;

public class PruebaEliminarPorIDHuesped
{
	public static void main(String[] args)
	{
		HuespedesController controller = new HuespedesController();
		
		String id = "4";
		
		controller.eliminarId(id);
		
		System.out.println("Se elimino el registro de huesped");
	}
}
