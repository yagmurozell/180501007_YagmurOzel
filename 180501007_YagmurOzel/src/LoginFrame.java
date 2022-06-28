import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;



public class LoginFrame extends Konnektor {

	private JPanel contentPane;
	private JTextField txtNichtVerbunden;
	static JTextField userField;
	Konnektor login = new Konnektor();
	static JPasswordField passwordField_1;
	private JLabel loginicon_1;
	private JLabel lblNewLabel_1;
	static JButton btnNewButton;
	
	

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		
		
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNichtVerbunden = new JTextField();
		txtNichtVerbunden.setHorizontalAlignment(SwingConstants.CENTER);
		txtNichtVerbunden.setBackground(new Color(255, 255, 255));
		txtNichtVerbunden.setBounds(535, 12, 103, 20);
		contentPane.add(txtNichtVerbunden);
		txtNichtVerbunden.setColumns(10);
		txtNichtVerbunden.setText("nicht verbunden");
		txtNichtVerbunden.setForeground(Color.RED);

		userField = new JTextField();
		userField.setBounds(171, 193, 86, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Benutzername :");
		lblNewLabel.setForeground(new Color(0, 153, 204));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(34, 191, 127, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Passwort :");
		lblPassword.setForeground(new Color(0, 153, 204));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 16));
		lblPassword.setBounds(34, 243, 110, 20);
		contentPane.add(lblPassword);
		
		
		JButton btnNewButton = new JButton("verbinden");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login.conn();
				txtNichtVerbunden.setText("verbunden");
				txtNichtVerbunden.setForeground(new Color(0, 102, 0));
				
			}
		});
		btnNewButton.setBounds(422, 11, 103, 23);
		contentPane.add(btnNewButton); 
		
		
		JButton btnNewButton_1 = new JButton("Einloggen");
		btnNewButton_1.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_1.setForeground(new Color(0, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Konnektor.stat_loginUser();
	
				
			}
		});
		btnNewButton_1.setBounds(171, 311, 131, 37);
		contentPane.add(btnNewButton_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(171, 245, 86, 20);
		contentPane.add(passwordField_1);
		
		loginicon_1 = new JLabel("");
		Image img = new ImageIcon (this.getClass().getResource ("/cleaning2.png")).getImage();
		loginicon_1.setIcon(new ImageIcon (img));
		loginicon_1.setBounds(391, 156, 247, 247);
		contentPane.add(loginicon_1);
		//Image img2 = new ImageIcon (this.getClass().getResource ("/welcome6.png")).getImage();
		
		lblNewLabel_1 = new JLabel("WILLKOMMEN");
		lblNewLabel_1.setForeground(new Color(0, 153, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(172, 57, 316, 75);
		contentPane.add(lblNewLabel_1);
		

		
		
	}
}
