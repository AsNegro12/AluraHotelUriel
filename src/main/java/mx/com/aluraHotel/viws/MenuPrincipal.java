package mx.com.aluraHotel.viws;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Cursor;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal()
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 910, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImageMenu = new JLabel("");
		lblImageMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/menu-img.png")));
		lblImageMenu.setBounds(-20, 0, 732, 501);
		panel.add(lblImageMenu);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/aH-150px.png")));
		lblLogo.setBounds(735, 80, 150, 156);
		panel.add(lblLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(75, 129, 252));
		panel_1.setBounds(0, 500, 910, 37);
		panel.add(panel_1);
		
		JLabel lblCopyR = new JLabel("Desarrollado por Uriel E. Flores Ruiz © 2023");
		lblCopyR.setForeground(new Color(240, 248, 255));
		lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel_1.add(lblCopyR);
		panel.setLayout(null);
		
		JPanel Header = new JPanel();
		Header.setBounds(0, 0, 910, 37);
		Header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e)
			{
				headerMouseDragged(e);
			}
		});
		Header.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				headerMousePressed(e);
			}
		});
		Header.setLayout(null);
		Header.setBackground(Color.WHITE);
		panel.add(Header);
		
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
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(857, 0, 53, 36);
		Header.add(btnExit);
		
		labelExit = new JLabel("X");
		btnExit.add(labelExit);
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel btnLogin = new JLabel("");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.window);
		btnLogin.setBounds(754, 300, 83, 70);
		panel.add(btnLogin);
		
		JLabel lblLogin = new JLabel("");
		panel.add(lblLogin);
		lblLogin.setBounds(768, 300, 83, 70);
		lblLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/login.png")));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setBackground(UIManager.getColor("window"));
		lblTitulo.setBounds(768, 260, 83, 24);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
		
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
