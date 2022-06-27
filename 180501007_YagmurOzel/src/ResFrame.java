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

public class ResFrame extends Konnektor {

	private JPanel contentPane;
	private JTable table;
	
   DefaultTableModel b = new DefaultTableModel();
  
	
	Object[] columns = { "Reservations_Nr", "Kunden_TC", "Date","Produkt"};
	Object[] rows = new Object [4];
	private JTextField tc_txt;
	private JTextField res_txt;
	private JTextField date_txt;
	private JTextField produkt_txt;

	private JLabel lblKunden;
	private JLabel lblRes;
	private JLabel lblDate;
	private JLabel lblProdukt;
	private JTextField textFieldTC;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResFrame frame = new ResFrame();
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
	public ResFrame() {
		 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton editButton = new JButton("Bearbeiten");
		editButton.setBackground(new Color(204, 255, 255));
		editButton.setBounds(188, 327, 89, 23);
 		contentPane.add(editButton);
 		
 		
 		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	             
	             int selected_row = table.getSelectedRow();
	             if(selected_row>=0)
	         		{
	            	 	tc_txt.setEditable(false);
	            	 	String res_num = table.getValueAt(selected_row,0).toString();
	            	 	String user_TC = table.getValueAt(selected_row,1).toString();
	            	 	String date = table.getValueAt(selected_row,2).toString();
	            	 	String produkt = table.getValueAt(selected_row,3).toString();
	            
	                	tc_txt.setText(user_TC);
	                	res_txt.setText(res_num);
	                	date_txt.setText(date);
	                	produkt_txt.setText(produkt);
	              
	                	
	                	 
	    	     		editButton.addActionListener(new ActionListener() {
	    	     			public void actionPerformed(ActionEvent e) {
	    	     				
	    	     				Statement stmt;
	    	                     try {
	    	                         stmt = myConn.createStatement();
	    	                         String edit = "UPDATE reservation SET Date = '"+date_txt.getText()+"' , Produkt = '"+produkt_txt.getText()+"', Reservations_Nr = '"+res_num+"'"
	    	                         		+ " WHERE Kunden_TC = '"+user_TC+"'";
	    	                         int x = stmt.executeUpdate(edit);
	    	                         if (x > 0)
	    	                             JOptionPane.showMessageDialog(editButton,"Erfolgreich bearbeitet. Bitte AKTUALISIEREN-BUTTON verwenden!");
	    	                         else
	    	                             JOptionPane.showMessageDialog(editButton,"Bearbeitung fehlgeschlagen");

	    	                        

	    	                     } catch (SQLException e1) {
	    	                         // TODO Auto-generated catch block
	    	                         e1.printStackTrace();
	    	                     }
	    	     				
	    	     				
	    	     			}
	    	     		});
	         				 
	         		}
	             	
				
			}
		});
		scrollPane.setBounds(31, 51, 576, 252);
		contentPane.add(scrollPane);
		
		table = new JTable();
		b.setColumnIdentifiers(columns);
		b.addRow(rows);
		table.setModel(b);
		scrollPane.setViewportView(table);
		
		JButton addButton = new JButton("Hinzuf\u00FCgen");
		addButton.setBackground(new Color(204, 255, 255));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_TC = tc_txt.getText();
				String res_num = res_txt.getText();
				String date = date_txt.getText();
				String produkt = produkt_txt.getText();

				Statement stmt;
				try {
					stmt = myConn.createStatement();
					
					String insert = "INSERT INTO reservation ( `Reservations_Nr`,`Kunden_TC`, `Date`, `Produkt`) VALUES "
							+ "('"+res_num+"', '"+user_TC+"','"+date+"','"+produkt+"')";
					int x = stmt.executeUpdate(insert);
					if (x > 0)
						JOptionPane.showMessageDialog(addButton,"Erfolgreich eingefügt. Bitte AKTUALISIEREN-BUTTON verwenden!");
		            else
		            	JOptionPane.showMessageDialog(addButton,"Einfügen fehlgeschlagen");


					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		addButton.setBounds(89, 327, 89, 23);
		contentPane.add(addButton);
		
		
		
		JButton deleteButton = new JButton("L\u00F6schen");
		deleteButton.setBackground(new Color(204, 255, 255));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user_TC = tc_txt.getText();
				String res_num = res_txt.getText();
				String date = date_txt.getText();
				String produkt = produkt_txt.getText();

				conn();
				Statement stmt;
				try {
					stmt = myConn.createStatement();
					
					String delete = "DELETE FROM reservation WHERE Kunden_TC = '"+user_TC+"'";
					int x = stmt.executeUpdate(delete);
					if (x > 0)
						JOptionPane.showMessageDialog(deleteButton,"Erfolgreich gelöscht. Bitte AKTUALISIEREN-BUTTON verwenden!");
		            else
		            	JOptionPane.showMessageDialog(deleteButton,"Löschen fehlgeschlagen");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		deleteButton.setBounds(287, 327, 89, 23);
		contentPane.add(deleteButton);
		
		JButton updateButton = new JButton("Aktualisieren");
		updateButton.setBackground(new Color(204, 255, 255));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 b.setRowCount(0);
				 ResultSet myRs = Konnektor.stat_res();
				 try {
	                 while(myRs.next()) {
	                     rows[0] = myRs.getString("Reservations_Nr");    
	                     rows[1] = myRs.getString("Kunden_TC");
	                     rows[2] = myRs.getString("Date");
	                     rows[3] = myRs.getString("Produkt");

	                     b.addRow(rows);
	                 }

	                 
	             } catch (SQLException e1) {
	                 e1.printStackTrace();
	             }

	             table.setModel(b);
			
			}
		});
		
		
		updateButton.setBounds(386, 327, 102, 23);
		contentPane.add(updateButton);
		
		tc_txt = new JTextField();
		tc_txt.setBounds(775, 99, 86, 20);
		contentPane.add(tc_txt);
		tc_txt.setColumns(10);
		
		res_txt = new JTextField();
		res_txt.setColumns(10);
		res_txt.setBounds(775, 68, 86, 20);
		contentPane.add(res_txt);
		
		date_txt = new JTextField();
		date_txt.setColumns(10);
		date_txt.setBounds(775, 130, 86, 20);
		contentPane.add(date_txt);
		
		produkt_txt = new JTextField();
		produkt_txt.setColumns(10);
		produkt_txt.setBounds(775, 160, 86, 20);
		contentPane.add(produkt_txt);

		lblKunden = new JLabel("Kunden TC :");
		lblKunden.setForeground(new Color(0, 153, 204));
		lblKunden.setFont(new Font("Arial", Font.BOLD, 13));
		lblKunden.setBounds(658, 99, 89, 20);
		contentPane.add(lblKunden);
		
		lblDate = new JLabel("Date :");
		lblDate.setForeground(new Color(0, 153, 204));
		lblDate.setFont(new Font("Arial", Font.BOLD, 13));
		lblDate.setBounds(658, 133, 97, 14);
		contentPane.add(lblDate);
		
		lblProdukt = new JLabel("Produkt :");
		lblProdukt.setForeground(new Color(0, 153, 204));
		lblProdukt.setFont(new Font("Arial", Font.BOLD, 13));
		lblProdukt.setBounds(658, 163, 89, 14);
		contentPane.add(lblProdukt);
		
		
		lblRes = new JLabel("Reservations Nr. :");
		lblRes.setForeground(new Color(0, 153, 204));
		lblRes.setFont(new Font("Arial", Font.BOLD, 13));
		lblRes.setBounds(658, 71, 118, 14);
		contentPane.add(lblRes);
		
		JButton btnNewButton = new JButton("Abfrage des Reservations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b.setRowCount(0);
				
				ResultSet myRs = Konnektor.stat_res();
				

				Statement stmt;
				try {
					stmt = myConn.createStatement();
					
					String quest = "SELECT * FROM reservation WHERE Kunden_TC = '"+textFieldTC.getText()+"' ";
					
					    stmt.executeQuery(quest);
					    
					    
					    
					    if(myRs.next()) {
	                    rows[0] = myRs.getString("Reservations_Nr");    
	                    rows[1] = myRs.getString("Kunden_TC");
	                    rows[2] = myRs.getString("Date");
	                    rows[3] = myRs.getString("Produkt");

	                    b.addRow(rows);}


					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
				  table.setModel(b);
					
				
			}
		});
		btnNewButton.setBounds(686, 361, 244, 49);
		contentPane.add(btnNewButton);
		
		textFieldTC = new JTextField();
		textFieldTC.setBounds(798, 328, 86, 20);
		contentPane.add(textFieldTC);
		textFieldTC.setColumns(10);
		
		JLabel lblKunden_1 = new JLabel("Kunden TC :");
		lblKunden_1.setForeground(new Color(0, 153, 204));
		lblKunden_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblKunden_1.setBounds(699, 328, 89, 20);
		contentPane.add(lblKunden_1);
	}
}

