package mx.com.aluraHotel.viws;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import mx.com.aluraHotel.Controller.HuespedesController;
import mx.com.aluraHotel.Controller.ReservasController;
import mx.com.aluraHotel.modelo.Huespedes;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;

import javax.swing.JTextField;

public class RegistroHuespedes extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textField;
	
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNumReserva;
	
	private JDateChooser txtFechaN;
	private JComboBox<Format> txtNacionalidad;
	
	private HuespedesController registroH;
	private ReservasController reservasController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuespedes frame = new RegistroHuespedes(0L);
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
	public RegistroHuespedes(Long idReserva) 
	{
		this.registroH = new HuespedesController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 910, 634);
		panel.setBackground(SystemColor.window);
		contentPane.add(panel);
		setLocationRelativeTo(null);
		setUndecorated(true);
		panel.setLayout(null);
		
		
		//Separadores
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(SystemColor.textHighlight);
		separator1.setBounds(579, 361, 289, 2);
		separator1.setBackground(SystemColor.textHighlight);
		panel.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setForeground(SystemColor.textHighlight);
		separator2.setBounds(579, 287, 289, 2);
		separator2.setBackground(SystemColor.textHighlight);
		panel.add(separator2);
		
		JSeparator separator3 = new JSeparator();
		separator3.setForeground(SystemColor.textHighlight);
		separator3.setBounds(579, 509, 289, 2);
		separator3.setBackground(SystemColor.textHighlight);
		panel.add(separator3);
		
		JSeparator separator4 = new JSeparator();
		separator4.setForeground(SystemColor.textHighlight);
		separator4.setBounds(579, 435, 289, 2);
		separator4.setBackground(SystemColor.textHighlight);
		panel.add(separator4);
		
		JSeparator separator5 = new JSeparator();
		separator5.setForeground(SystemColor.textHighlight);
		separator5.setBounds(579, 213, 289, 2);
		separator5.setBackground(SystemColor.textHighlight);
		panel.add(separator5);
		
		JSeparator separator6 = new JSeparator();
		separator6.setForeground(SystemColor.textHighlight);
		separator6.setBounds(579, 139, 289, 2);
		separator6.setBackground(SystemColor.textHighlight);
		panel.add(separator6);
		
		//Registro huésped
		JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
		lblTitulo.setBounds(609, 29, 219, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto black", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		//Nombre del huesped
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(SystemColor.textInactiveText);
		lblNombre.setBounds(579, 82, 196, 14);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(579, 107, 289, 29);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtNombre);
		
		//Apellido del huesped
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(SystemColor.textInactiveText);
		lblApellido.setBounds(579, 152, 196, 22);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(579, 180, 289, 29);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setColumns(10);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtApellido);
		
		//Fecha de nacimiento del huesped
		JLabel lblFechaN = new JLabel("Fecha de nacimiento");
		lblFechaN.setForeground(SystemColor.textInactiveText);
		lblFechaN.setBounds(579, 226, 196, 22);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFechaN);
		
		txtFechaN = new JDateChooser();
		txtFechaN.getCalendarButton().setIcon(new ImageIcon(RegistroHuespedes.class.getResource("/imagenes/reservado.png")));
		txtFechaN.setBounds(579, 248, 289, 36);
		txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		panel.add(txtFechaN);
		
		//Nacionalidad del huesped
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setForeground(SystemColor.textInactiveText);
		lblNacionalidad.setBounds(579, 300, 196, 22);
		lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblNacionalidad);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(579, 324, 289, 36);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
		panel.add(txtNacionalidad);
		
		//Telefono del huesped
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setBounds(579, 374, 196, 22);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(579, 400, 289, 29);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtTelefono);
		
		//Numero de reserva del huesped
		JLabel lblNumReserva = new JLabel("Numero de reserva");
		lblNumReserva.setForeground(SystemColor.textInactiveText);
		lblNumReserva.setBounds(579, 448, 196, 22);
		lblNumReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblNumReserva);
		
		txtNumReserva = new JTextField();
		txtNumReserva.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNumReserva.setBounds(579, 476, 289, 29);
		txtNumReserva.setBackground(Color.WHITE);
		txtNumReserva.setColumns(10);
		txtNumReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		System.out.println(idReserva);
		String id = String.valueOf(idReserva);
		txtNumReserva.setText(id);
		panel.add(txtNumReserva);
		
		//JPanel JImagenFondo
		JPanel JImagenFondo = new JPanel();
		JImagenFondo.setBounds(0, 0, 554, 634);
		JImagenFondo.setBackground(new Color(12, 138, 199));
		JImagenFondo.setLayout(null);
		panel.add(JImagenFondo);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setIcon(new ImageIcon(RegistroHuespedes.class.getResource("/imagenes/registro.png")));
		lblImagenFondo.setBounds(31, 122, 479, 501);
		JImagenFondo.add(lblImagenFondo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(RegistroHuespedes.class.getResource("/imagenes/Ha-100px.png")));
		lblLogo.setBounds(219, 37, 109, 100);
		JImagenFondo.add(lblLogo);
		
		//boton guardar
		JPanel btnGuardar = new JPanel();
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				guardarHuespedes();
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnGuardar.setBackground(new Color(12, 138, 255));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnGuardar.setBackground(new Color(12, 138, 199));
			}
		});
		btnGuardar.setBounds(746, 560, 122, 35);
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(new Color(12, 138, 199));
		panel.add(btnGuardar);
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblGuardar = new JLabel("GUARDAR");
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.WHITE);
		lblGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblGuardar.setBounds(0, 0, 122, 35);
		btnGuardar.add(lblGuardar);
		
		//Header
		JPanel header = new JPanel();
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
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
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
		
		//boton atras
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter()
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
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		JImagenFondo.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
	}
	
	private void guardarHuespedes()
	{
		if(txtFechaN.getDate() != null && !txtNombre.equals("") && !txtApellido.equals("") && !txtTelefono.equals(""))
		{
			
			
			String fechaN = ((JTextField)txtFechaN.getDateEditor().getUiComponent()).getText();
			Long NumReserva = (long) Integer.parseInt(txtNumReserva.getText());
			
			Huespedes huespedes = new Huespedes(txtNombre.getText(),
					txtApellido.getText(),
					java.sql.Date.valueOf(fechaN),
					txtNacionalidad.getSelectedItem().toString(),
					txtTelefono.getText(), NumReserva);
			
			this.registroH.guardar(huespedes);
			
			JOptionPane.showMessageDialog(this, "Se guardo con exito");
			MenuUsuario menuUsuario = new MenuUsuario();
			menuUsuario.setVisible(true);
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Debes llenar todos los campos.");
		}	
	}
}
