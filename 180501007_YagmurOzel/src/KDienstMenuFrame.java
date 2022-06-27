import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KDienstMenuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KDienstMenuFrame frame = new KDienstMenuFrame();
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
	public KDienstMenuFrame() {
		
		 KundenFrame kf = new KundenFrame();
		 ResFrame rf =new ResFrame();
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnKundenFrame = new JButton("KUNDEN INFO");
		btnKundenFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kf.setTitle("Willkommen");
                kf.setVisible(true);
                JOptionPane.showMessageDialog(btnKundenFrame, "Sie haben sich erfolgreich angemeldet");
			}
		});
		btnKundenFrame.setBackground(new Color(204, 255, 255));
		btnKundenFrame.setBounds(147, 246, 118, 23);
		contentPane.add(btnKundenFrame);
		
		JButton btnNewButton_1 = new JButton("RESERVIERUNG");
		btnNewButton_1.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setBounds(462, 246, 133, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.setTitle("Willkommen");
                rf.setVisible(true);
                JOptionPane.showMessageDialog(btnKundenFrame, "Sie haben sich erfolgreich angemeldet");
			}
		});
		
		JLabel lblRezicon = new JLabel("New label");
		Image img = new ImageIcon (this.getClass().getResource ("/calendar.png")).getImage();
		lblRezicon.setIcon(new ImageIcon (img));
		lblRezicon.setBounds(433, 53, 175, 175);
		contentPane.add(lblRezicon);
		
		JLabel lblKundenicon = new JLabel("New label");
		Image img2 = new ImageIcon (this.getClass().getResource ("/costumer.png")).getImage();
		lblKundenicon.setIcon(new ImageIcon (img2));
		lblKundenicon.setBounds(116, 53, 175, 175);
		contentPane.add(lblKundenicon);
	}
}
