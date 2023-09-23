package mx.com.aluraHotel.pruebas;

import java.sql.Date;

import mx.com.aluraHotel.Controller.ReservasController;
import mx.com.aluraHotel.modelo.Reserva;

public class PruebaGuardarReserva
{
	public static void main(String[] args) 
	{
		Date fecha1 = Date.valueOf("2023-09-12");
		Date fecha2 = Date.valueOf("2023-09-14");
		
		String[] metodosDePago = {"Efectivo", "Tarjeta de crédito", "Tarjeta de débito", "Transferencia"};
		
		ReservasController controller = new ReservasController();
		Reserva reserva = new Reserva(fecha1, fecha2, "123", metodosDePago[1]);
		
		controller.guardar(reserva);
	}
}
