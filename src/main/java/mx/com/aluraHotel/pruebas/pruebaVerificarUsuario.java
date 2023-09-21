package mx.com.aluraHotel.pruebas;

import mx.com.aluraHotel.Controller.UsuariosController;

public class pruebaVerificarUsuario
{
	public static void main(String[] args)
	{
		UsuariosController usuariosController = new UsuariosController();
		
		String usuario = "urielAdimin";
		String clave = "123456";
		
		boolean inicioExitoso = usuariosController.iniciarSesion(usuario, clave);
		
		if(inicioExitoso)
		{
			System.out.println("Inicio de sesión exitoso. ");
		}
		else
		{
			System.out.println("Inicio de sesión fallido.");
		}
	}
}
