package mx.com.aluraHotel.pruebas;

import java.sql.Date;

import mx.com.aluraHotel.Controller.HuespedesController;
import mx.com.aluraHotel.modelo.Huespedes;

public class PruebaGuardarHuesped
{
	public static void main(String[] args) 
	{
		Date fecha = Date.valueOf("2001-12-12");
		
		HuespedesController controller = new HuespedesController();
		Huespedes huespedes = new Huespedes("Uriel", "Flores", fecha, "mexicana", "123456", 1L);
		
		
		controller.guardar(huespedes);
		

	}
}
