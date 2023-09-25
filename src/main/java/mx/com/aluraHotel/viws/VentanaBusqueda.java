package mx.com.aluraHotel.viws;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mx.com.aluraHotel.Controller.HuespedesController;
import mx.com.aluraHotel.Controller.ReservasController;
import mx.com.aluraHotel.modelo.Huespedes;
import mx.com.aluraHotel.modelo.Reserva;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Optional;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

public class VentanaBusqueda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JLabel labelExit;
	private JTable tbReservas;
	private DefaultTableModel modeloHuesped;
	private DefaultTableModel modeloReserva;
	private HuespedesController huespedesController;
	private ReservasController reservaController;
	private JTable tbHuespedes;
	private int xMouse,yMouse;
	private String reserva;
	private String huespedes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBusqueda frame = new VentanaBusqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaBusqueda() 
	{
		this.reservaController = new ReservasController();
		this.huespedesController = new HuespedesController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tbReservas);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 910, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Titulo sistemas de búsqueda
		JLabel lblTitulo = new JLabel("SISTEMA DE BÚSQUEDA");
		lblTitulo.setBounds(316, 11, 265, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto black", Font.BOLD, 22));
		panel.add(lblTitulo);
		
		//Logo		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(VentanaBusqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblLogo.setBounds(39, 65, 105, 100);
		panel.add(lblLogo);
		//
		//Aqui el usuario busca huesped o reserva por id
		//
		txtBuscar = new JTextField();
		txtBuscar.setBounds(575, 100, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		//Separadores
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(SystemColor.textHighlight);
		separator1.setBounds(575, 136, 193, 2);
		separator1.setBackground(SystemColor.textHighlight);
		panel.add(separator1);
		
		//Boton buscar
		JPanel btnBuscar = new JPanel();
		btnBuscar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				limpiarTabla();
				
				if(txtBuscar.getText().equals(""))
				{
					ExisteAntesDeLlenar();
				}
				else
				{
					ExisteAntesDeLlenar();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnBuscar.setBackground(new Color(12, 138, 255));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnBuscar.setBackground(new Color(12, 138, 199));
			}
		});
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBounds(778, 100, 122, 38);
		btnBuscar.setLayout(null);
		btnBuscar.setBackground(new Color(12, 138, 199));
		panel.add(btnBuscar);
		
		//lblBuscar
		JLabel lblbuscar = new JLabel("Buscar");
		lblbuscar.setBounds(0, 0, 122, 38);
		lblbuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblbuscar.setForeground(Color.WHITE);
		lblbuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblbuscar.setBounds(0, 0, 122, 35);
		btnBuscar.add(lblbuscar);
		//
		//Aqui se muestran las tablas de huespedes y reservas
		//
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 174, 890, 337);
		tabbedPane.setBackground(new Color(12, 138, 199));
		tabbedPane.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.add(tabbedPane);
		
		tbHuespedes = new JTable();
		tabbedPane.addTab("Huespedes", new ImageIcon(VentanaBusqueda.class.getResource("/imagenes/pessoas.png")), tbHuespedes, null);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 14));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Numero de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Numero de Reserva");
		tbHuespedes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		LlenarTablaHuespedes();
		
		tbReservas = new JTable();
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 14));
		tabbedPane.addTab("Reservas", new ImageIcon(VentanaBusqueda.class.getResource("/imagenes/reservado.png")), tbReservas, null);
		modeloReserva = (DefaultTableModel) tbReservas.getModel();
		modeloReserva.addColumn("Numero de Reserva");
		modeloReserva.addColumn("Fecha Check In");
		modeloReserva.addColumn("Fecha Check Out");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Forma de Pago");
		tbReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		LlenarTablaReservas();
		
		//
		//Pica esta cosa y sales de aca
		//
		//Header
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent e)
			{
				headerMouseDragged(e);
			}
		});
		header.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		header.setLayout(null);
		panel.add(header);
		//
		//Boton Salir
		//
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(SystemColor.text);
				labelExit.setForeground(Color.black);
			}
		});
		btnExit.setLayout(null);
		btnExit.setBackground(SystemColor.text);
		btnExit.setBounds(857, 0, 53, 36);
		header.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		//
		//BotonEditar
		//
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int filaReservas = tbReservas.getSelectedRow();
				int filaHuespedes = tbHuespedes.getSelectedRow();

				if (filaReservas >= 0) {
					ActualizarReservas();
					limpiarTabla();
					LlenarTablaReservas();
					LlenarTablaHuespedes();
				}
				else if (filaHuespedes >= 0)
				{
					ActualizarHuesped();
					limpiarTabla();
					LlenarTablaHuespedes();
					LlenarTablaReservas();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnEditar.setBackground(new Color(12, 138, 255));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnEditar.setBackground(new Color(12, 138, 199));
			}
		});
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setBounds(646, 522, 122, 38);
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		panel.add(btnEditar);
		
		//lblEditar
		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setBounds(0, 0, 122, 38);
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		//
		//BotonEliminar
		//
		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int filaHuespedes = tbHuespedes.getSelectedRow();
				int filaReservas = tbReservas.getSelectedRow();
				
				if(filaReservas >= 0)
				{
					reserva = tbReservas.getValueAt(filaReservas, 0).toString();
					int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar los datos?"); 

					if(confirmar == JOptionPane.YES_OPTION){

						String valor = tbReservas.getValueAt(filaReservas, 0).toString();			
						reservaController.eliminarId(valor);
						JOptionPane.showMessageDialog(contentPane, "Registro Eliminado");
						limpiarTabla();
						LlenarTablaReservas();
						LlenarTablaHuespedes();
					}
				}
				else if(filaReservas >= 0)
				{
					huespedes = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
					int confirmarh = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar los datos?"); 

					if(confirmarh == JOptionPane.YES_OPTION)
					{

						String valor = tbHuespedes.getValueAt(filaHuespedes, 0).toString();			
						huespedesController.eliminarId(valor);
						JOptionPane.showMessageDialog(contentPane, "Registro Eliminado");
						limpiarTabla();
						LlenarTablaHuespedes();
						LlenarTablaReservas();
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnEliminar.setBackground(new Color(12, 138, 255));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnEliminar.setBackground(new Color(12, 138, 199));
			}
		});
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBounds(778, 522, 122, 38);
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		panel.add(btnEliminar);
		
		//lblEditar
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(0, 0, 122, 38);
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		
	}
	
	private List<Reserva> BuscarReservas()
	{
		return this.reservaController.ListarReservas();
	}
	
	private List<Reserva> BuscarReservasId() 
	{
		return this.reservaController.listarReservaPorID(txtBuscar.getText());
	}
	
	private List<Huespedes> BuscarHuespedes()
	{
		return this.huespedesController.ListarHuespedes();
	}
	
	private List<Huespedes> BuscarHuespedesId()
	{
		return this.huespedesController.listarHuespedesPorID(txtBuscar.getText());
	}
	//
	//Limpia las tablas
	//
	private void limpiarTabla()
	{
		((DefaultTableModel) tbHuespedes.getModel()).setRowCount(0);
		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
	}
	//
	//Esta parte del codigo, se encarga de llena las tablas huespedes y reservas.
	//
	private void LlenarTablaHuespedes()
	{			       
	    //Llenar Tabla
		List<Huespedes> huesped = BuscarHuespedes();
		
		try
		{	
			for (Huespedes huespedes : huesped)
			{
				modeloHuesped.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(), huespedes.getFechaNacimiendo(), huespedes.getNacionalidad(), huespedes.getTelefono(), huespedes.getIdReserva() });
			}
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	private void LlenarTablaHuespedesId()
	{			       
	    //Llenar Tabla
		List<Huespedes> huesped = BuscarHuespedesId();

		try
		{

			for (Huespedes huespedes : huesped)
			{
				modeloHuesped.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(), huespedes.getFechaNacimiendo(), huespedes.getNacionalidad(), huespedes.getTelefono(), huespedes.getIdReserva() });
			}
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	private void LlenarTablaReservas() {

	    // Llenar tabla
		List<Reserva> reserva = BuscarReservas();
		try {
			for (Reserva reservas : reserva) {
				modeloReserva.addRow(new Object[] { reservas.getId(), reservas.getFecha_entrada(), reservas.getFecha_salida(), reservas.getValor(), reservas.getFormato_pago()});
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void LlenarTablaReservasId() {

	    // Llenar tabla
		List<Reserva> reserva = BuscarReservasId();
		
		try
		{
			for (Reserva reservas : reserva)
			{
				modeloReserva.addRow(new Object[] {  reservas.getId(), reservas.getFecha_entrada(), reservas.getFecha_salida(), reservas.getValor(), reservas.getFormato_pago() });
			}	
		} 
		catch (Exception e)
		{
			throw e;
		}
	}
	//
	//Esta parte del codigo, se encarga de capturar y editar los campos.
	//
	private void ActualizarReservas()
	{		
		Optional.ofNullable(modeloReserva.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
        .ifPresentOrElse(fila -> {
        	
        	Date fechaE = Date.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 1).toString());		
        	Date fechaS = Date.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 2).toString());
			String valor = (String) modeloReserva.getValueAt(tbReservas.getSelectedRow(), 3);
			String formaPago = (String) modeloReserva.getValueAt(tbReservas.getSelectedRow(), 4);
			Long id = Long.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 0).toString());
			this.reservaController.editarReservas(fechaE, fechaS, valor, formaPago, id);
			JOptionPane.showMessageDialog(this, String.format("Registro modificado con éxito"));
		}, () -> {
			JOptionPane.showMessageDialog(this, "Por favor, elije un registro");
			});
		
	}
	
	private void ActualizarHuesped()
	{		
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
        .ifPresentOrElse(filaHuesped -> {
        	
        	String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
        	String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
        	Date fechaN = Date.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
			String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
			String telefono = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5);
			Long idReserva = Long.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
			Long id = Long.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
			this.huespedesController.editarHuespedes(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
			JOptionPane.showMessageDialog(this, String.format("Registro modificado con éxito"));
		}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un registro"));
		
	}
	//
	//Busca si exite el  en huespedes o reservas, sino lanza un mesaje de que no existe
	//
	private boolean ExisteElIdHuesped()
	{
		return this.huespedesController.existeID(txtBuscar.getText());
	}
	
	private boolean ExisteElIdReserva()
	{
		return this.reservaController.existeID(txtBuscar.getText());
	}
	
	private void ExisteAntesDeLlenar()
	{
		boolean existeReserva = ExisteElIdReserva();
		boolean existeHuesped = ExisteElIdHuesped();
		
		if(existeReserva || existeHuesped)
		{
			LlenarTablaReservasId();
			LlenarTablaHuespedesId();
		}
		else if(txtBuscar.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Para buscar debes ingresar un número de Huésped o Reserva. ");
			LlenarTablaHuespedes();
			LlenarTablaReservas();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No existe el numero de Huésped o reserva");
			LlenarTablaHuespedes();
			LlenarTablaReservas();
		}
	}
	
	 private void headerMousePressed(java.awt.event.MouseEvent evt)
	 {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt)
	    {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
	    }
}
