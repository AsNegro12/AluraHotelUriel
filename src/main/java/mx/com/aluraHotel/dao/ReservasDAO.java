package mx.com.aluraHotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.com.aluraHotel.factory.ConnectionFactory;
import mx.com.aluraHotel.modelo.Huespedes;
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
	
	public List<Reserva> ListarReservas()
	{
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		try
		{
			String query = "SELECT "
					+ "id, "
					+ "fecha_entrada, "
					+ "fecha_salida, valor, "
					+ "formato_pago "
					+ "FROM reserva";
			
			try(PreparedStatement statement = con.prepareStatement(query))
			{
				statement.execute();
				
				transformarResultSetEnReseva(reservas, statement);
			}
			return reservas;
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> burcarPorId(String id)
	{
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		try
		{
			String query = "SELECT "
					+ "id, "
					+ "fecha_entrada, "
					+ "fecha_salida, valor, "
					+ "formato_pago "
					+ "FROM reserva "
					+ "WHERE id=?";;
			
			try(PreparedStatement statement = con.prepareStatement(query))
			{
				statement.setString(1,id);
				statement.execute();
				
				transformarResultSetEnReseva(reservas, statement);
			}
			return reservas;
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
			String query = "SELECT * FROM reserva WHERE id=?";
			
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
	transformarResultSetEnReseva(List<Reserva> reservas, PreparedStatement statement) throws SQLException
	{
		try(ResultSet rst = statement.getResultSet())
		{
			while(rst.next())
			{
				Reserva reserva = new Reserva(
						rst.getLong(1), 
						rst.getDate(2), 
						rst.getDate(3), 
						rst.getString(4),
						rst.getString(5));
				
				reservas.add(reserva);
			}
			
		}
	}
}
