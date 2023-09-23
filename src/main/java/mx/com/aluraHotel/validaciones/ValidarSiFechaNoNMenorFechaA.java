package mx.com.aluraHotel.validaciones;

import java.time.LocalDate;

public class ValidarSiFechaNoNMenorFechaA {

	public boolean fechaValida(String fecha)
	{
		try
		{
            LocalDate fechaIngresada = LocalDate.parse(fecha);
            LocalDate fechaActual = LocalDate.now();
            return !fechaIngresada.isBefore(fechaActual);
            
        }
		catch (Exception e)
		{
			e.printStackTrace();
            return false; // La fecha ingresada no es válida
        }
	}
	
	public boolean fechaSalidaMenor(String fechaE, String fechaS)
	{
		try
		{
			LocalDate fecha1 = LocalDate.parse(fechaE);
            LocalDate fecha2 = LocalDate.parse(fechaS);
            return !fecha2.isBefore(fecha1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
            return false; // La fecha ingresada no es válida
		}
	}
}
