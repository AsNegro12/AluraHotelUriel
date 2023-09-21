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
	
	public boolean validarCredenciales(String usuario, String clave)
	{
		try
		{
			String query = "SELECT * FROM usuarios WHERE usuario=? AND clave=?";
			
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, clave);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
