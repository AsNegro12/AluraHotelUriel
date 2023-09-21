package mx.com.aluraHotel.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import mx.com.aluraHotel.factory.ConnectionFactory;

public class PruebaConexion
{
	public static void main(String[] args) throws SQLException
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexion();
		
		System.out.println("Probando conexion!!");
		
		con.close();
		
		System.out.println("Cerrando conexion");
	}
}
