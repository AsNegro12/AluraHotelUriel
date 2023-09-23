package mx.com.aluraHotel.viws;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import mx.com.aluraHotel.Controller.ReservasController;
import mx.com.aluraHotel.modelo.Reserva;
import mx.com.aluraHotel.validaciones.ValidarSiFechaNoNMenorFechaA;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("unused")
public class RegistrarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ReservasController reservasController;
	private JLabel labelExit;
	private JLabel labelAtras;
	public static JDateChooser txtFechaE;
	public static JDateChooser txtFechaS;
	int xMouse, yMouse;
	public static JTextField txtValor;
	private JComboBox txtFormaPago = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarReserva frame = new RegistrarReserva();
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
	public RegistrarReserva() 
	{
		this.reservasController = new ReservasController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		setLocationRelativeTo(null);
		setUndecorated(true);
		panel.setLayout(null);
		
		//Separadores
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(SystemColor.textHighlight);
		separator1.setBounds(68, 281, 289, 11);
		separator1.setBackground(SystemColor.textHighlight);
		panel.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(SystemColor.textHighlight);
		separator2.setBounds(68, 195, 289, 2);
		separator2.setBackground(SystemColor.textHighlight);
		panel.add(separator2);
		
		JSeparator separator3 = new JSeparator();
		separator3.setForeground(SystemColor.textHighlight);
		separator3.setBounds(68, 453, 289, 2);
		separator3.setBackground(SystemColor.textHighlight);
		panel.add(separator3);
		
		JSeparator separator4 = new JSeparator();
		separator4.setForeground(SystemColor.textHighlight);
		separator4.setBounds(68, 362, 289, 2);
		separator4.setBackground(SystemColor.textHighlight);
		panel.add(separator4);
		
		//Valor de la reservación
		JLabel lblValor = new JLabel("Valor de la reservación");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(68, 303, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		//Forma de pago
		JLabel lblFormapago = new JLabel("Forma de pago");
		lblFormapago.setForeground(SystemColor.textInactiveText);
		lblFormapago.setBounds(68, 375, 187, 24);
		lblFormapago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormapago);
		
		//Fecha de check in
		JLabel lblfechaIn = new JLabel("Fecha de check in");
		lblfechaIn.setForeground(SystemColor.textInactiveText);
		lblfechaIn.setBounds(68, 126, 187, 24);
		lblfechaIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblfechaIn);
				
		//Fecha de check out
		JLabel lblFechaOut = new JLabel("Fecha de check out");
		lblFechaOut.setForeground(SystemColor.textInactiveText);
		lblFechaOut.setBounds(68, 211, 187, 24);
		lblFechaOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFechaOut);
		
		//Sistema de reservaciones
		JLabel lblTitulo = new JLabel("Sistema de reservaciones");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setBounds(97, 60, 237, 42);
		lblTitulo.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel.add(lblTitulo);
		//
		//Fondo imagen
		//
		JPanel fondoImagen = new JPanel();
		fondoImagen.setBounds(428, 0, 482, 560);
		fondoImagen.setBackground(new Color(12, 138, 199));
		fondoImagen.setLayout(null);
		panel.add(fondoImagen);
		
		//logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(RegistrarReserva.class.getResource("/imagenes/Ha-100px.png")));
		lblLogo.setBounds(197, 68, 104, 107);
		fondoImagen.add(lblLogo);
		
		//Imagen de fondo
		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(RegistrarReserva.class.getResource("/imagenes/reservas-img-3.png")));
		ImagenFondo.setBounds(0, 140, 482, 409);
		ImagenFondo.setBackground(Color.WHITE);
		fondoImagen.add(ImagenFondo);
		
		//
		//Boton para salir
		//
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		fondoImagen.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		//
		//Boton atras
		//
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		//boton atras
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		//
		//Campos que guardaremos en la base de datos
		//
		//fechas de llegada
		txtFechaE = new JDateChooser();
		txtFechaE.getCalendarButton().setIcon(new ImageIcon(RegistrarReserva.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaE.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaE.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaE.setBounds(68, 161, 289, 35);
		txtFechaE.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaE.setBackground(Color.WHITE);
		txtFechaE.setBorder(new LineBorder(SystemColor.window));
		txtFechaE.setDateFormatString("yyyy-MM-dd");
		txtFechaE.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(txtFechaE);
		
		//fechas de salida
		txtFechaS  = new JDateChooser();
		txtFechaS.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent evt)
			{
				calcularValor(txtFechaE,txtFechaS);
			}
		});
		txtFechaS.getCalendarButton().setIcon(new ImageIcon(RegistrarReserva.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaS .getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaS .getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaS .setBounds(68, 246, 289, 35);
		txtFechaS .getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaS .setBackground(Color.WHITE);
		txtFechaS .setBorder(new LineBorder(SystemColor.window));
		txtFechaS .setDateFormatString("yyyy-MM-dd");
		txtFechaS .setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(txtFechaS);
		
		txtValor = new JTextField("$");
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(78, 328, 69, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		txtFormaPago = new JComboBox<String>();
		txtFormaPago.setBounds(68, 411, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel<String>(new String[] {"Tarjeta de Crédito",
				"Tarjeta de Débito",
				"Dinero en efectivo",
				"Trasferencia"}));
		panel.add(txtFormaPago);
		
		//Botón Siguiente		
		JPanel btnsiguiente = new JPanel();
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtFechaE.getDate() != null && txtFechaS.getDate() != null))
				{
					guardarReserva();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
				}
			}
			public void mouseEntered(MouseEvent e)
			{
				btnsiguiente.setBackground(new Color(12, 138, 255));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnsiguiente.setBackground(new Color(12, 138, 199));
			}
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(new Color(12, 138, 199));
		btnsiguiente.setBounds(238, 493, 122, 35);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		//Botón Siguiente	
		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 112, 35);
		btnsiguiente.add(lblSiguiente);	
	}
	
	private void calcularValor(JDateChooser fechaE,JDateChooser fechaS) {		
		if(fechaE.getDate() != null && fechaS.getDate() !=null) {
			Calendar inicio = fechaE.getCalendar();
			Calendar fin = fechaS.getCalendar();
			int dias = -1; // Usamos -1 para contar a partir del dia siguiente
			int diaria = 500;
			int valor;
			
			while(inicio.before(fin)||inicio.equals(fin)) {
				dias++;
				inicio.add(Calendar.DATE,1); //dias a ser aumentados
			}
			valor = dias * diaria;
			txtValor.setText("$" + valor);
		}
	}
	
	private void guardarReserva()
	{
		ValidarSiFechaNoNMenorFechaA validarFecha = new ValidarSiFechaNoNMenorFechaA();
		
		String fechaE = ((JTextField)txtFechaE.getDateEditor().getUiComponent()).getText();
		String fechaS = ((JTextField)txtFechaS.getDateEditor().getUiComponent()).getText();
		
		if(!validarFecha.fechaValida(fechaE))
		{
			JOptionPane.showMessageDialog(null, "Fecha ingresada no válida. Por favor, ingresa una fecha válida.");
			return;
		}
		else if(!validarFecha.fechaSalidaMenor(fechaE, fechaS))
		{
			JOptionPane.showMessageDialog(null, "La fecha de salida debe ser posterior o igual a la fecha de entrada.");
			return;
		}
		else
		{
			Reserva nuevaReserva = new Reserva(java.sql.Date.valueOf(fechaE),java.sql.Date.valueOf(fechaS),
					txtValor.getText(),txtFormaPago.getSelectedItem().toString());
			
			reservasController.guardar(nuevaReserva);
							
			RegistroHuespedes huespedes =  new RegistroHuespedes(nuevaReserva.getId());
			huespedes.setVisible(true);
			dispose();
		}
		
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
