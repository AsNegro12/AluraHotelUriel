package mx.com.aluraHotel.viws;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 788, 527);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(484, 0, 304, 527);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		//Imagen de fondo img-hotel-login-.png
		JLabel lblImgFondo = new JLabel("");
		lblImgFondo.setBounds(0, 0, 304, 538);

		panel_1.add(lblImgFondo);
		//
		//Salir de la aplicacion
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
				 btnExit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnExit.setBounds(251, 0, 53, 36);
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_1.add(btnExit);
		panel.setLayout(null);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		//
		//TextField
		//
		//txtUsuario
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if(txtUsuario.getText().equals("Ingrese su nombre de usuario"))
				{
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
				}
				if(String.valueOf(txtContrasena.getPassword()).isEmpty())
				{
		        	txtContrasena.setText("********");
		        	txtContrasena.setForeground(Color.gray);
				}
			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 212, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		//
		//JPasswordField
		//
		//txtContrasena
		txtContrasena = new JPasswordField();
		txtContrasena.setText("********");
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if(String.valueOf(txtContrasena.getPassword()).equals("********"))
				{
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
				}
				if(txtUsuario.getText().isEmpty())
				{
		        	txtUsuario.setText("Ingrese su nombre de usuario");
		        	txtUsuario.setForeground(Color.gray);
				}
			}
		});
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setBounds(65, 360, 324, 32);
		panel.add(txtContrasena);
		//
		//Separadores
		//
		JSeparator separator = new JSeparator();
		separator.setBounds(65, 256, 324, 2);
		separator.setBackground(new Color(0, 120, 215));
		panel.add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(65, 404, 324, 2);
		separator2.setBackground(new Color(0, 120, 215));
		panel.add(separator2);
		//
		//Titulos
		//
		JLabel lblTitulo = new JLabel("Usuario: ");
		lblTitulo.setBounds(65, 175, 202, 26);
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		panel.add(lblTitulo);
		
		JLabel lblTitulo2 = new JLabel("Contraseña: ");
		lblTitulo2.setBounds(65, 298, 202, 26);
		lblTitulo2.setForeground(SystemColor.textHighlight);
		lblTitulo2.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		panel.add(lblTitulo2);
		//
		//boton para logiarse
		//
		JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				LoginLogica();
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btnLogin.setBackground(new Color(0, 156, 223));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				btnLogin.setBackground(SystemColor.textHighlight);
			}
		});
		btnLogin.setBounds(163, 431, 122, 44);
		panel.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.textHighlight);
		
		JLabel lblLogin = new JLabel("Iniciar Sesión");
		lblLogin.setBounds(0, 0, 122, 44);
		btnLogin.add(lblLogin);
		lblLogin.setForeground(SystemColor.controlLtHighlight);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Roboto", Font.PLAIN, 18));

		//Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lOGO-50PX.png")));
		lblLogo.setBounds(198, 37, 69, 59);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLogo);
		
		//Header
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter(){
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
		header.setBounds(0, 0, 784, 36);
		panel.add(header);
		header.setLayout(null);
		header.setBackground(SystemColor.window);
		
	}
	
	private void LoginLogica()
	{
		System.out.println("hola");
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
