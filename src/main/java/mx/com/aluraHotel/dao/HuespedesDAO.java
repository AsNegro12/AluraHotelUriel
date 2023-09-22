package mx.com.aluraHotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.com.aluraHotel.factory.ConnectionFactory;
import mx.com.aluraHotel.modelo.Huespedes;

public class HuespedesDAO
{

	private Connection con;
	
	public HuespedesDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.recuperarConexion();
	}
	
	public void GuardarHuesped(Huespedes huespedes)
	{
		try
		{
			String query = "INSERT INTO huespedes "
					+ "(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReserva) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
			{
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setDate(3, huespedes.getFechaNacimiendo());
				statement.setString(4, huespedes.getNacionalidad());
				statement.setString(5, huespedes.getTelefono());
				statement.setLong(6, huespedes.getIdReserva());
				
				statement.execute();
				
				try(ResultSet rst = statement.getGeneratedKeys())
				{
					while(rst.next())
					{
						huespedes.setId(rst.getLong(1));
					}
				}
				
			}
			
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
