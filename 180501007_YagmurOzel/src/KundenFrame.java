import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KundenFrame extends Konnektor {

	private JPanel contentPane;
	private JTable table;
	
   DefaultTableModel a = new DefaultTableModel();
  
	
	Object[] columns = {"Kunden_TC", "Vorname", "Nacname","email","telefonnummer", "Produkt_id", "Reservations_Nr"};
	Object[] rows = new Object [7];
	private JTextField tc_txt;
	private JTextField vorn_txt;
	private JTextField nach_txt;
	private JTextField email_txt;
	private JTextField tel_txt;
	private JTextField id_txt;
	private JTextField num_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KundenFrame frame = new KundenFrame();
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
	public KundenFrame() {
		 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(185, 308, 89, 23);
 		contentPane.add(editButton);
 		
 		
 		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	             
	             int selected_row = table.getSelectedRow();
	             if(selected_row>=0)
	         		{
	            	 	tc_txt.setEditable(false);
	            	 	String user_TC = table.getValueAt(selected_row,0).toString();
	            	 	String vorname = table.getValueAt(selected_row,1).toString();
	            	 	String nachname = table.getValueAt(selected_row,2).toString();
	            	 	String email = table.getValueAt(selected_row,3).toString();
	            	 	String tel = table.getValueAt(selected_row,4).toString();
	            	 	String produkt_id = table.getValueAt(selected_row,5).toString();
	            	 	String rez_num = table.getValueAt(selected_row,6).toString();
	            	 	
	                	tc_txt.setText(user_TC);
	                	vorn_txt.setText(vorname);
	                	nach_txt.setText(nachname);
	                	email_txt.setText(email);
	                	tel_txt.setText(tel);
	                	id_txt.setText(produkt_id);
	                	num_txt.setText(rez_num);
	                	
	                	 
	    	     		editButton.addActionListener(new ActionListener() {
	    	     			public void actionPerformed(ActionEvent e) {
	    	     				
	    	     				Statement stmt;
	    	                     try {
	    	                         stmt = myConn.createStatement();
	    	                         String edit = "UPDATE kunden SET Vorname = '"+vorn_txt.getText()+"' , Nachname = '"+nach_txt.getText()+"', email = '"+email_txt.getText()+"', telefonnummer = '"+tel_txt.getText()+"' , Produkt_id = '"+id_txt.getText()+"' , Reservations_Nr = '"+num_txt.getText()+"'"
	    	                         		+ " WHERE Kunden_TC = '"+user_TC+"'";
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
		scrollPane.setBounds(79, 52, 380, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		a.setColumnIdentifiers(columns);
		a.addRow(rows);
		table.setModel(a);
		scrollPane.setViewportView(table);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_TC = tc_txt.getText();
				String vorname = vorn_txt.getText();
				String nachname = nach_txt.getText();
				String email = email_txt.getText();
				String tel = tel_txt.getText();
				String produkt_id = id_txt.getText();
				String rez_num = num_txt.getText();
				Statement stmt;
				try {
					stmt = myConn.createStatement();
					
					String insert = "INSERT INTO kunden (`Kunden_TC`, `Vorname`, `Nachname`, `email`, `telefonnummer`, `Produkt_id`, `Reservations_Nr`) VALUES "
							+ "('"+user_TC+"', '"+vorname+"','"+nachname+"','"+email+"','"+tel+"','"+produkt_id+"','"+rez_num+"')";
					int x = stmt.executeUpdate(insert);
					if (x > 0)
						JOptionPane.showMessageDialog(addButton,"Successfully Inserted. Please use UPDATE BUTTON!");
		            else
		            	JOptionPane.showMessageDialog(addButton,"Insert Failed");


					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		addButton.setBounds(86, 308, 89, 23);
		contentPane.add(addButton);
		
		
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user_TC = tc_txt.getText();
				String vorname = vorn_txt.getText();
				String nachname = nach_txt.getText();
				String email = email_txt.getText();
				String tel = tel_txt.getText();
				String produkt_id = id_txt.getText();
				String rez_num = num_txt.getText();
				conn();
				Statement stmt;
				try {
					stmt = myConn.createStatement();
					
					String delete = "DELETE FROM kunden WHERE Kunden_TC = '"+user_TC+"'";
					int x = stmt.executeUpdate(delete);
					if (x > 0)
						JOptionPane.showMessageDialog(deleteButton,"Successfully Deleted. Please use UPDATE BUTTON!");
		            else
		            	JOptionPane.showMessageDialog(deleteButton,"Deletion Failed");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		deleteButton.setBounds(284, 308, 89, 23);
		contentPane.add(deleteButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 a.setRowCount(0);
				 ResultSet myRs = Konnektor.stat_kunden();
				 try {
	                 while(myRs.next()) {
	                     rows[0] = myRs.getString("Kunden_TC");    
	                     rows[1] = myRs.getString("Vorname");
	                     rows[2] = myRs.getString("Nachname");
	                     rows[3] = myRs.getString("email");
	                     rows[4] = myRs.getString("telefonnummer");
	                     rows[5] = myRs.getString("Produkt_id");
	                     rows[6] = myRs.getString("Reservations_Nr");
	                     a.addRow(rows);
	                 }

	                 
	             } catch (SQLException e1) {
	                 e1.printStackTrace();
	             }

	             table.setModel(a);
			
			}
		});
		
		
		updateButton.setBounds(383, 308, 89, 23);
		contentPane.add(updateButton);
		
		tc_txt = new JTextField();
		tc_txt.setBounds(551, 66, 86, 20);
		contentPane.add(tc_txt);
		tc_txt.setColumns(10);
		
		vorn_txt = new JTextField();
		vorn_txt.setColumns(10);
		vorn_txt.setBounds(551, 97, 86, 20);
		contentPane.add(vorn_txt);
		
		nach_txt = new JTextField();
		nach_txt.setColumns(10);
		nach_txt.setBounds(551, 128, 86, 20);
		contentPane.add(nach_txt);
		
		email_txt = new JTextField();
		email_txt.setColumns(10);
		email_txt.setBounds(551, 159, 86, 20);
		contentPane.add(email_txt);
		
		tel_txt = new JTextField();
		tel_txt.setColumns(10);
		tel_txt.setBounds(551, 190, 86, 20);
		contentPane.add(tel_txt);
		
		id_txt = new JTextField();
		id_txt.setColumns(10);
		id_txt.setBounds(551, 221, 86, 20);
		contentPane.add(id_txt);
		
		num_txt = new JTextField();
		num_txt.setColumns(10);
		num_txt.setBounds(551, 252, 86, 20);
		contentPane.add(num_txt);
	}
}
