package mx.com.aluraHotel.Controller;

import mx.com.aluraHotel.dao.UsuariosDAO;

public class UsuariosController
{
	private UsuariosDAO dao;
	
	public UsuariosController()
	{
		dao = new UsuariosDAO();
	}
	
	public boolean iniciarSesion(String usuario, String clave)
	{
		return dao.validarCredenciales(usuario, clave);
	}
}
