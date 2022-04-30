import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.ColorAttribute;
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



public class LoginFrame extends Konnektor {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField userField;
	Konnektor login = new Konnektor();
	private JPasswordField passwordField_1;
	
	
    
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
		setBounds(100, 100, 571, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setBounds(459, 12, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("Not Connected");
		textField.setForeground(Color.RED);

		userField = new JTextField();
		userField.setBounds(209, 121, 86, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(131, 124, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(131, 168, 52, 20);
		contentPane.add(lblPassword);
		
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login.conn();
				textField.setText("Connected");
				textField.setForeground(Color.GREEN);
				
			}
		});
		btnNewButton.setBounds(348, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Login");
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
		btnNewButton_1.setBounds(206, 224, 89, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(209, 168, 86, 20);
		contentPane.add(passwordField_1);
		
		
		
		
	}
}
