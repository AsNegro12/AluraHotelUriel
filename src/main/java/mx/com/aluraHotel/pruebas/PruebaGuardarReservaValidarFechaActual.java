package mx.com.aluraHotel.pruebas;

import java.sql.Date;
import java.time.LocalDate;

import mx.com.aluraHotel.Controller.ReservasController;
import mx.com.aluraHotel.modelo.Reserva;

public class PruebaGuardarReservaValidarFechaActual
{
	public static void main(String[] args) 
	{
		Date fecha1 = Date.valueOf("2023-09-26");
		Date fecha2 = Date.valueOf("2023-09-20");
		
		LocalDate fechaActual = LocalDate.now();
		if(fecha1.toLocalDate().isBefore(fechaActual))
		{
			System.out.println(fecha1+" No es es una fecha valida porque es anterior a la fecha actual");
		}
		else if(fecha2.toLocalDate().isBefore(fecha1.toLocalDate()))
		{
			System.out.println("Error. La fecha de salida "+fecha2+", no puede ser anterior a la fecha de llegada "+fecha1);
		}
		else
		{
			String[] metodosDePago = {"Efectivo", "Tarjeta de crédito", "Tarjeta de débito", "Transferencia"};
			
			ReservasController controller = new ReservasController();
			Reserva reserva = new Reserva(fecha1, fecha2, "123", metodosDePago[1]);
			
			controller.guardar(reserva);
		}
	}
}
