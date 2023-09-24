package mx.com.aluraHotel.viws;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelRegistro;
	private JLabel labelExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 944, 609);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		//
		//Menu del usuario
		//
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		//Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));
		lblLogo.setBounds(44, 53, 156, 150);
		panelMenu.add(lblLogo);
		
		//Separador
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 214, 201, 2);
		panelMenu.add(separator);
		
		//boton registro
		JPanel btnRegistro = new JPanel();
		btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistro.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				RegistrarReserva registrarReserva = new RegistrarReserva();
				registrarReserva.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnRegistro.setBackground(new Color(118, 187, 223));	
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnRegistro.setBackground(new Color(12, 138, 199));
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setLayout(null);
		btnRegistro.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistro);
		
		//label registro
		JLabel lblRegistro = new JLabel("Registro de reservas");
		lblRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		lblRegistro.setForeground(SystemColor.text);
		lblRegistro.setBounds(25, 11, 205, 34);
		lblRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(lblRegistro);
		
		//boton buscar
		JPanel btnBuscar = new JPanel();
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				VentanaBusqueda busqueda = new VentanaBusqueda();
				busqueda.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnBuscar.setBackground(new Color(118, 187, 223));	
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnBuscar.setBackground(new Color(12, 138, 199));
			}
		});
		btnBuscar.setBounds(0, 312, 257, 56);
		btnBuscar.setLayout(null);
		btnBuscar.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnBuscar);
		
		JLabel lblbuscar = new JLabel("Búsqueda");
		lblbuscar.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		lblbuscar.setBounds(102, 11, 46, 14);
		lblbuscar.setForeground(SystemColor.text);
		lblbuscar.setBounds(25, 11, 205, 34);
		lblbuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblbuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.add(lblbuscar);
		
		//Panel de la fecha
		JPanel panelFecha = new JPanel();
		panelFecha.setBounds(256, 84, 688, 121);
		panelFecha.setBackground(new Color(118, 187, 223));
		panelFecha.setLayout(null);
		panel.add(panelFecha);
		
		//Titulo del sistema
		JLabel lblTitulo = new JLabel("Sistema de reservas Hotel Alura");
	    lblTitulo.setBounds(180, 11, 356, 42);
	    lblTitulo.setForeground(Color.WHITE);
	    lblTitulo.setFont(new Font("Roboto", Font.PLAIN, 24));
		panelFecha.add(lblTitulo);
		
		//fecha
		JLabel lblFecha = new JLabel("New label");
		lblFecha.setBounds(35, 64, 294, 36);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Roboto", Font.PLAIN, 24));
		panelFecha.add(lblFecha);
		
		Date fechaActual = new Date();
		String fecha = new SimpleDateFormat("dd/mm/yy").format(fechaActual);
		lblFecha.setText("Hoy es "+fecha);
		//
		//Body
		//
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Roboto", Font.BOLD, 24));
	    lblBienvenido.setBounds(302, 234, 147, 46);
		panel.add(lblBienvenido);
		
		String textoDescripcion = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima "
				+ "y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>";
		
		JLabel lblDescripcion1 = new JLabel(textoDescripcion);
		lblDescripcion1.setBounds(312, 291, 598, 66);
		lblDescripcion1.setFont(new Font("Roboto", Font.PLAIN, 17));
		panel.add(lblDescripcion1);
		
		String textoDescripcion2 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado"
				+ " de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
		
		JLabel lblDescripcion2 = new JLabel(textoDescripcion2);
		lblDescripcion2.setBounds(311, 345, 569, 88);
		lblDescripcion2.setFont(new Font("Roboto", Font.PLAIN, 17));
		panel.add(lblDescripcion2);
		
		JLabel lblDescripcion3 = new JLabel("- Registro de Reservas y Huéspedes");
		lblDescripcion3.setBounds(312, 444, 295, 27);
		lblDescripcion3.setFont(new Font("Roboto", Font.PLAIN, 17));
		panel.add(lblDescripcion3);
		
		JLabel lblDescripcion4 = new JLabel("- Edición de Reservas y Huéspedes existentes");
		lblDescripcion4.setBounds(312, 482, 355, 27);
		lblDescripcion4.setFont(new Font("Roboto", Font.PLAIN, 17));
		panel.add(lblDescripcion4);
		
		JLabel lblDescripcion5 = new JLabel("- Eliminar todo tipo de registros");
		lblDescripcion5.setBounds(312, 520, 295, 27);
		lblDescripcion5.setFont(new Font("Roboto", Font.PLAIN, 17));
		panel.add(lblDescripcion5);
		
		//
		//header
		//
		JPanel header = new JPanel();
		header.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				headerMousePressed(e);
			}
		});
		header.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent e)
			{
				headerMouseDragged(e);
			}
		});
		panel.add(header);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		//
		//Boton de cerrar apliacion
		//
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnExit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnExit.setBounds(889, 0, 55, 36);
		btnExit.setLayout(null);
		btnExit.setBackground(Color.WHITE);
		header.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 56, 36);
		btnExit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt)
	{
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt)
    {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
