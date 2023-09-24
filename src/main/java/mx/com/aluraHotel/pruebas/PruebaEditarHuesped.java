package mx.com.aluraHotel.pruebas;

import java.sql.Date;

import mx.com.aluraHotel.Controller.HuespedesController;

public class PruebaEditarHuesped
{
	public static void main(String[] args)
	{
		HuespedesController controller = new HuespedesController();
		
		String nombre = "David";
        String apellido = "Antunez";
        Date fechaN = Date.valueOf("2000-12-24");
        String nacionalidad = "portugués-portuguesa";
        String telefono = "6531237856";
        Long idReserva = 4L;
        Long id = 4L;
		
		controller.editarHuespedes(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
		
		System.out.println("Se Actualizo exitosatente");
	}
}
