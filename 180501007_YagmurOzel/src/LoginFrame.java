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
	private JTextField textField;
	private JTextField userField;
	Konnektor login = new Konnektor();
	private JPasswordField passwordField_1;
	private JLabel loginicon_1;
	private JLabel loginicon_2;
	
	

    
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
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(535, 12, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Not Connected");
		textField.setForeground(Color.RED);

		userField = new JTextField();
		userField.setBounds(171, 193, 86, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setForeground(new Color(0, 153, 204));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(34, 191, 110, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 153, 204));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 16));
		lblPassword.setBounds(34, 243, 110, 20);
		contentPane.add(lblPassword);
		
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login.conn();
				textField.setText("Connected");
				textField.setForeground(new Color(0, 102, 0));
				
			}
		});
		btnNewButton.setBounds(436, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_1.setForeground(new Color(0, 153, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String username = userField.getText();
				String password = passwordField_1.getText();
				try {
					PreparedStatement st = (PreparedStatement) myConn
							.prepareStatement("SELECT username, password FROM user WHERE username=? AND password=?");
					
					st.setString(1, username);
					st.setString(2, password);
					
					ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        
                        ProduktFrame pf = new ProduktFrame();
                	    KundenFrame kf = new KundenFrame();
                	    AdminFrame af = new AdminFrame();
                	    //ReinigungFrame rf = new ReinigungFrame();
                      
                	    switch (username) {
					case "admin": {
						af.setTitle("Welcome");
                        af.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in with credentials ADMIN");
						break;
					
					}
					case "kundendienst":{
						kf.setTitle("Welcome");
                        kf.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in with credentials KUNDENDIENST");
                        break;
					}
					case "buchhalter" :{
						pf.setTitle("Welcome");
                        pf.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in with credentials BUCHHALTER");
                        break;
						
					}
					case "reinigung" :{
						//rf.setTitle("Welcome");
                       // rf.setVisible(true);
                       // JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                        break;
						
					}

					default:
						throw new IllegalArgumentException("Unexpected value: " + username);
					}
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
					
					
                    }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		
		loginicon_2 = new JLabel("");
		Image img2 = new ImageIcon (this.getClass().getResource ("/welcome6.png")).getImage();
		loginicon_2.setIcon(new ImageIcon (img2));
		loginicon_2.setBounds(197, 34, 259, 94);
		contentPane.add(loginicon_2);
		

		
		
	}
}
