package mx.com.aluraHotel.viws;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.com.aluraHotel.Controller.ReservasController;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class RegistrarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ReservasController reservasController;
	private JLabel labelExit;

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
		
		//Valor de la reservación
		JLabel lblValor = new JLabel("Valor de la reservación");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		panel.add(lblValor);
		
		//Forma de pago
		JLabel lblFormapago = new JLabel("Forma de pago");
		lblFormapago.setForeground(SystemColor.textInactiveText);
		lblFormapago.setBounds(68, 382, 187, 24);
		lblFormapago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormapago);
		
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
	}
}
