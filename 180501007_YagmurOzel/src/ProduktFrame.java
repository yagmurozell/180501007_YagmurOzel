import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class ProduktFrame extends Konnektor {
	
	Konnektor x = new Konnektor();

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	DefaultTableModel y = new DefaultTableModel();
	
	Object[] columns = {"Produkt_id", "Name", "Kosten"};
	Object[] rows = new Object [3];
	private JTextField kosten_txt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProduktFrame frame = new ProduktFrame();
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
	public ProduktFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 28, 396, 257);
		contentPane.add(scrollPane);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(256, 350, 89, 23);
		contentPane.add(editButton);
		
		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			     int selected_row = table.getSelectedRow();
	             if(selected_row>=0)
	         		{
	            	 	String produkt_id = table.getValueAt(selected_row,0).toString();
	            	 	String kosten_produkt = table.getValueAt(selected_row,2).toString();
	                	kosten_txt.setText(kosten_produkt);
	                	
	    	     		editButton.addActionListener(new ActionListener() {
	    	     			public void actionPerformed(ActionEvent e) {	
	    	     				Statement stmt;
	    	                     try {
	    	                         stmt = myConn.createStatement();
	    	                         String edit = "UPDATE produkt SET Kosten = '"+kosten_txt.getText()+"' WHERE Produkt_id = '"+produkt_id+"'";
	    	                         int x = stmt.executeUpdate(edit);
	    	                         if (x > 0)
	    	                             JOptionPane.showMessageDialog(editButton,"Successfully Edited. Please use UPDATE BUTTON!");
	    	                         else
	    	                             JOptionPane.showMessageDialog(editButton,"Edit Failed");

	    	                        

	    	                     } catch (SQLException e1) {
	    	                         // TODO Auto-generated catch block
	    	                         e1.printStackTrace();
	    	                     }
	    	     				
	    	     				
	    	     			}
	    	     		});
	         				 
	         		}
			}
		});
		
		
		JButton btnNewButton = new JButton("Produkt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 y.setRowCount(0);
			 ResultSet myRs = Konnektor.stat_produkt();
			 
			 try {
                 while(myRs.next()) {
                     rows[0] = myRs.getString("Produkt_id");
                     rows[1] = myRs.getString("Name");
                     rows[2] = myRs.getString("Kosten");
                    
                     y.addRow(rows);
                 }
             } catch (SQLException e1) {
                 e1.printStackTrace();
             }

             table.setModel(y);
				 
				
	
			}
		});
		btnNewButton.setBounds(111, 337, 89, 23);
		contentPane.add(btnNewButton);
		
	
		

		table = new JTable();
		y.setColumnIdentifiers(columns);
		y.addRow(rows);
		table.setModel(y);
		table.setBounds(162, 59, 241, 102);
		scrollPane.setViewportView(table);
		

		
		kosten_txt = new JTextField();
		kosten_txt.setBounds(491, 94, 86, 20);
		contentPane.add(kosten_txt);
		kosten_txt.setColumns(10);
	
		//contentPane.add(table);
		
		
		
	}
}
		
