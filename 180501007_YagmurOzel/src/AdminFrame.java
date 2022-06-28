import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class AdminFrame extends Konnektor {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**s
	 * Create the frame.
	 */
	public AdminFrame() {
		
		ProduktFrame pf = new ProduktFrame();
	    KundenFrame kf = new KundenFrame();
	    KDienstMenuFrame df = new KDienstMenuFrame();
	  ReinigungFrame rf = new ReinigungFrame();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton kundenButton = new JButton("KUNDENDIENST");
		kundenButton.setBackground(new Color(204, 255, 255));
		kundenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.setTitle("Willkommen");
                df.setVisible(true);
                JOptionPane.showMessageDialog(kundenButton, "Sie haben sich erfolgreich angemeldet");
			}
		});
		kundenButton.setBounds(86, 260, 140, 23);
		contentPane.add(kundenButton);
		
		JButton produktButton = new JButton("PRODUKT");
		produktButton.setBackground(new Color(204, 255, 255));
		produktButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf.setTitle("Willkommen");
                pf.setVisible(true);
                JOptionPane.showMessageDialog(produktButton, "Sie haben sich erfolgreich angemeldet");
			}
		});
		produktButton.setBounds(391, 260, 118, 23);
		contentPane.add(produktButton);
		
		JButton btnPuffhouse = new JButton("RE\u0130N\u0130GUNG");
		btnPuffhouse.setBackground(new Color(204, 255, 255));
		btnPuffhouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.setTitle("Welcome");
                rf.setVisible(true);
               JOptionPane.showMessageDialog(produktButton, "Sie haben sich erfolgreich angemeldet");
			
			}
		});
		btnPuffhouse.setBounds(716, 260, 134, 23);
		contentPane.add(btnPuffhouse);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img2 = new ImageIcon (this.getClass().getResource ("/costumer.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img2));
		lblNewLabel.setBounds(51, 68, 175, 175);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image img3 = new ImageIcon (this.getClass().getResource ("/box.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon (img3));
		lblNewLabel_1.setBounds(366, 68, 175, 175);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		Image img4 = new ImageIcon (this.getClass().getResource ("/basket.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon (img4));
		lblNewLabel_2.setBounds(687, 68, 175, 175);
		contentPane.add(lblNewLabel_2);
	}

}
