package mx.com.aluraHotel.Controller;

import mx.com.aluraHotel.dao.UsuariosDAO;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class UsuariosController
{
	private UsuariosDAO dao;
	
	public UsuariosController()
	{
		dao = new UsuariosDAO();
	}
	
	public boolean iniciarSesion(String usuario, String clave)
	{
		String claveAlmcenada =  dao.validarCredenciales(usuario);
		
		if(claveAlmcenada != null)
		{
			return BCrypt.verifyer().verify(clave.toCharArray(), claveAlmcenada).verified;
		}
		else
		{
			 return false;
		}
	}
}
