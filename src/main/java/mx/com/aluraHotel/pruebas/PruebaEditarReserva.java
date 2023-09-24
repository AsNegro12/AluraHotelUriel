package mx.com.aluraHotel.pruebas;

import java.sql.Date;

import mx.com.aluraHotel.Controller.HuespedesController;
import mx.com.aluraHotel.Controller.ReservasController;

public class PruebaEditarReserva
{
	public static void main(String[] args)
	{
		ReservasController controller = new ReservasController();
		
		String valor = "$500";
        String formatoPago = "Dinero en efectivo";
        Date fechaEntrada = Date.valueOf("2023-09-24");
        Date fechaSalida = Date.valueOf("2023-09-26");
        Long id = 1L;
		
		controller.editarReservas(fechaEntrada, fechaSalida, valor, formatoPago, id);
		
		System.out.println("Se Actualizo exitosatente");
	}
}
