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
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

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
	private JLabel lblKunden;
	private JLabel lblVor;
	private JLabel lblNach;
	private JLabel lblEmail;
	private JLabel lblTel;
	private JLabel lblid;
	private JLabel lblrez;

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
		setBounds(100, 100, 903, 431);
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
		a.setColumnIdentifiers(columns);
		a.addRow(rows);
		table.setModel(a);
		scrollPane.setViewportView(table);
		
		JButton addButton = new JButton("Hinzuf\u00FCgen");
		addButton.setBackground(new Color(204, 255, 255));
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
		
		
		updateButton.setBounds(386, 327, 102, 23);
		contentPane.add(updateButton);
		
		tc_txt = new JTextField();
		tc_txt.setBounds(775, 68, 86, 20);
		contentPane.add(tc_txt);
		tc_txt.setColumns(10);
		
		vorn_txt = new JTextField();
		vorn_txt.setColumns(10);
		vorn_txt.setBounds(775, 99, 86, 20);
		contentPane.add(vorn_txt);
		
		nach_txt = new JTextField();
		nach_txt.setColumns(10);
		nach_txt.setBounds(775, 130, 86, 20);
		contentPane.add(nach_txt);
		
		email_txt = new JTextField();
		email_txt.setColumns(10);
		email_txt.setBounds(775, 160, 86, 20);
		contentPane.add(email_txt);
		
		tel_txt = new JTextField();
		tel_txt.setColumns(10);
		tel_txt.setBounds(775, 192, 86, 20);
		contentPane.add(tel_txt);
		
		id_txt = new JTextField();
		id_txt.setColumns(10);
		id_txt.setBounds(775, 223, 86, 20);
		contentPane.add(id_txt);
		
		num_txt = new JTextField();
		num_txt.setColumns(10);
		num_txt.setBounds(775, 254, 86, 20);
		contentPane.add(num_txt);
		
		lblKunden = new JLabel("Kunden TC :");
		lblKunden.setForeground(new Color(0, 153, 204));
		lblKunden.setFont(new Font("Arial", Font.BOLD, 13));
		lblKunden.setBounds(658, 68, 89, 20);
		contentPane.add(lblKunden);
		
		lblVor = new JLabel("Vorname :");
		lblVor.setForeground(new Color(0, 153, 204));
		lblVor.setFont(new Font("Arial", Font.BOLD, 13));
		lblVor.setBounds(658, 102, 97, 14);
		contentPane.add(lblVor);
		
		lblNach = new JLabel("Nachname :");
		lblNach.setForeground(new Color(0, 153, 204));
		lblNach.setFont(new Font("Arial", Font.BOLD, 13));
		lblNach.setBounds(658, 132, 89, 14);
		contentPane.add(lblNach);
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setForeground(new Color(0, 153, 204));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail.setBounds(658, 164, 89, 14);
		contentPane.add(lblEmail);
		
		lblTel = new JLabel("Telefonnummer :");
		lblTel.setForeground(new Color(0, 153, 204));
		lblTel.setFont(new Font("Arial", Font.BOLD, 13));
		lblTel.setBounds(656, 195, 120, 14);
		contentPane.add(lblTel);
		
		lblid = new JLabel("Produkt id :");
		lblid.setForeground(new Color(0, 153, 204));
		lblid.setFont(new Font("Arial", Font.BOLD, 13));
		lblid.setBounds(658, 226, 97, 14);
		contentPane.add(lblid);
		
		lblrez = new JLabel("Reservations Nr. :");
		lblrez.setForeground(new Color(0, 153, 204));
		lblrez.setFont(new Font("Arial", Font.BOLD, 13));
		lblrez.setBounds(658, 257, 118, 14);
		contentPane.add(lblrez);
	}
}
