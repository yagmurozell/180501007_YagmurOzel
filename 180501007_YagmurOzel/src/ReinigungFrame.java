import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class ReinigungFrame extends Konnektor {

	private JPanel contentPane;
	static  JTable table;
	
    static DefaultTableModel b = new DefaultTableModel();
  
	
	static Object[] columns = { "Reservations_Nr", "Kunden_TC", "Date","Produkt","Situation"};
	static Object[] rows = new Object [5];
	private JTextField situation_txt;
	private JLabel lblSt;
	private JTextField textField;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReinigungFrame frame = new ReinigungFrame();
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
	public ReinigungFrame() {
		


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nicht angefangen");
		comboBox.addItem("In Bearbeitung");
		comboBox.addItem("Abgeschlossen");
		comboBox.setBounds(760, 85, 97, 22);
		contentPane.add(comboBox);
		
		JLabel lblSituation = new JLabel("Situation :");
		lblSituation.setForeground(new Color(0, 153, 204));
		lblSituation.setFont(new Font("Arial", Font.BOLD, 13));
		lblSituation.setBounds(693, 89, 65, 14);
		contentPane.add(lblSituation);
		
		JButton btnBearbeiten = new JButton("Bearbeiten");
		
		btnBearbeiten.setBounds(712, 174, 108, 32);
		contentPane.add(btnBearbeiten);
 		
 		
 		JScrollPane scrollPane = new JScrollPane();
 		scrollPane.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				
 				
					
					int selected_row = table.getSelectedRow();
		             if(selected_row>=0) {
		            	
		            	String situationst = table.getValueAt(selected_row,4).toString();
		            	String res_num = table.getValueAt(selected_row,0).toString();
		            	comboBox.setSelectedItem(situationst);
				
				
					btnBearbeiten.addActionListener(new ActionListener() {
	 					public void actionPerformed(ActionEvent e) {
	 						
				
				
					Statement stmt;
	                try {
	                    stmt = myConn.createStatement();
	                    String edit = "UPDATE reservation SET Situation = '"+comboBox.getEditor().getItem()+"' WHERE Reservations_Nr = '"+res_num+"'";
	                    int x = stmt.executeUpdate(edit);
	                    if (x > 0)
	                    	JOptionPane.showMessageDialog(btnBearbeiten,"Erfolgreich bearbeitet. Bitte AKTUALISIEREN-BUTTON verwenden!");
	                    else
	                        JOptionPane.showMessageDialog(btnBearbeiten,"Bearbeitung fehlgeschlagen");

	                   

	                } catch (SQLException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
					
					
 				
 			}
 		});
			 
		}
 	

}
});



		scrollPane.setBounds(72, 43, 576, 252);
		contentPane.add(scrollPane);
		
		table = new JTable();
		b.setColumnIdentifiers(columns);
		b.addRow(rows);
		table.setModel(b);
		scrollPane.setViewportView(table);
		

		
		JButton updateButton = new JButton("Aktualisieren");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 b.setRowCount(0);

                 Konnektor.stat_reinigung_update();
	             table.setModel(b);
			
			}
		});
		
		
		updateButton.setBounds(843, 174, 108, 32);
		contentPane.add(updateButton);
		

	}
}

