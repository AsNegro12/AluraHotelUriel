package mx.com.aluraHotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public List<Huespedes> listaHuespedes()
	{
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		
		try
		{
			String query = "SELECT "
					+ "id, "
					+ "nombre, "
					+ "apellido, "
					+ "fecha_nacimiento, "
					+ "nacionalidad, "
					+ "telefono, "
					+ "idReserva "
					+ "FROM huespedes";
			
			try(PreparedStatement statement = con.prepareStatement(query))
			{
				statement.execute();
				
				transformarResultSetEnHuesped(huespedes, statement);
			}
			return huespedes;
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public List<Huespedes> burcarPorId(String id)
	{
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		
		try
		{
			String query = "SELECT "
					+ "id, "
					+ "nombre, "
					+ "apellido, "
					+ "fecha_nacimiento, "
					+ "nacionalidad, "
					+ "telefono, "
					+ "idReserva "
					+ "FROM huespedes "
					+ "WHERE id=?";
			
			try(PreparedStatement statement = con.prepareStatement(query))
			{
				statement.setString(1,id);
				statement.execute();
				
				transformarResultSetEnHuesped(huespedes, statement);
			}
			return huespedes;
		}
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean ExisteID(String id)
	{
		try
		{
			String query = "SELECT * FROM huespedes WHERE id=?";
			
			try(PreparedStatement statement = con.prepareStatement(query))
			{
				statement.setString(1,id);
				statement.execute();
				
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next())
				{
					return true;
				}
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		return false;
	}
	
	private void 
	transformarResultSetEnHuesped(List<Huespedes> reservas, PreparedStatement statement) throws SQLException
	{
		try(ResultSet rst = statement.getResultSet())
		{
			while(rst.next())
			{
				Huespedes huespedes = new Huespedes(
						rst.getLong(1), 
						rst.getString(2), 
						rst.getString(3), 
						rst.getDate(4), 
						rst.getString(5), 
						rst.getString(6), 
						rst.getLong(7));
				
				reservas.add(huespedes);
			}
			
		}
	}
}
