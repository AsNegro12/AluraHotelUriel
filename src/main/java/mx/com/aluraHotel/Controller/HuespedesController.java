package mx.com.aluraHotel.Controller;

import mx.com.aluraHotel.dao.HuespedesDAO;
import mx.com.aluraHotel.modelo.Huespedes;

public class HuespedesController
{
	private HuespedesDAO dao;
	
	public HuespedesController()
	{
		dao = new HuespedesDAO();
	}
	
	public void guardar(Huespedes huespedes)
	{
		dao.GuardarHuesped(huespedes);
	}
}
