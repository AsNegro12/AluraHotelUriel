package mx.com.aluraHotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.com.aluraHotel.factory.ConnectionFactory;

public class UsuariosDAO
{
	private Connection con;
	
	public UsuariosDAO()
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		con = connectionFactory.recuperarConexion();
	}
	
	public String validarCredenciales(String usuario)
	{
		try
		{
			String query = "SELECT clave FROM usuarios WHERE usuario=?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, usuario);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet.next())
			{
				return resultSet.getString("clave");
			}
			return null; // El usuario no existe
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
