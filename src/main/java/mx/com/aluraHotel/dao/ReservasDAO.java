package mx.com.aluraHotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.com.aluraHotel.factory.ConnectionFactory;
import mx.com.aluraHotel.modelo.Reserva;

public class ReservasDAO
{
	private Connection con;
	
	public ReservasDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.recuperarConexion();
	}
	
	public void guardarReserva(Reserva reserva)
	{
		try
		{
			String query = "INSERT INTO reserva "
					+ "(fecha_entrada, fecha_salida, valor, formato_pago) "
					+ "VALUES (?, ?, ?, ?)";
			
			try(PreparedStatement statement = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
			{
				statement.setDate(1,reserva.getFecha_entrada());
				statement.setDate(2,reserva.getFecha_salida());
				statement.setString(3,reserva.getValor());
				statement.setString(4,reserva.getFormato_pago());
				
				statement.execute();
				
				try(ResultSet rst = statement.getGeneratedKeys())
				{
					while(rst.next())
					{
						reserva.setId(rst.getLong(1));
					}
				}
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
