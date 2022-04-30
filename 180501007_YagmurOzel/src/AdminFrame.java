import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	  //ReinigungFrame rf = new ReinigungFrame();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton kundenButton = new JButton("KUNDEN");
		kundenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kf.setTitle("Welcome");
                kf.setVisible(true);
                JOptionPane.showMessageDialog(kundenButton, "You have successfully logged in");
			}
		});
		kundenButton.setBounds(46, 102, 89, 23);
		contentPane.add(kundenButton);
		
		JButton produktButton = new JButton("PRODUKT");
		produktButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf.setTitle("Welcome");
                pf.setVisible(true);
                JOptionPane.showMessageDialog(produktButton, "You have successfully logged in");
			}
		});
		produktButton.setBounds(254, 50, 89, 23);
		contentPane.add(produktButton);
		
		JButton btnPuffhouse = new JButton("PUFFHOUSE");
		btnPuffhouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//rf.setTitle("Welcome");
               // rf.setVisible(true);
               // JOptionPane.showMessageDialog(produktButton, "You have successfully logged in");
			
			}
		});
		btnPuffhouse.setBounds(273, 189, 89, 23);
		contentPane.add(btnPuffhouse);
	}

}
