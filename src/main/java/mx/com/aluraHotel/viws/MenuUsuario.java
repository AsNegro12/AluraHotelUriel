package mx.com.aluraHotel.viws;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelRegistro;

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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));
		lblLogo.setBounds(45, 101, 156, 150);
		panelMenu.add(lblLogo);
		
		
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
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		//
		//salir
		//
		JPanel btnExit = new JPanel();
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addMouseListener(new MouseAdapter() {
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
		btnExit.setLayout(null);
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBounds(857, 0, 53, 36);
		header.add(btnExit);
		contentPane.add(header);
		
		labelExit = new JLabel("X");
		labelExit.setBackground(new Color(255, 255, 255));
		btnExit.add(labelExit);
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
