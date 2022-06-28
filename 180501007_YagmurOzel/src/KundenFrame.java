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
	
   static DefaultTableModel a = new DefaultTableModel();
  
	
	static Object[] columns = {"Kunden_TC", "Vorname", "Nacname","email","telefonnummer"};
	static Object[] rows = new Object [5];
	static JTextField tc_txt;
	static JTextField vorn_txt;
	static JTextField nach_txt;
	static JTextField email_txt;
	static JTextField tel_txt;
	
	static JButton deleteButton;
	static JButton editButton;
	static JButton addButton;

	private JLabel lblKunden;
	private JLabel lblVor;
	private JLabel lblNach;
	private JLabel lblEmail;
	private JLabel lblTel;
	


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

	            	 	
	                	tc_txt.setText(user_TC);
	                	vorn_txt.setText(vorname);
	                	nach_txt.setText(nachname);
	                	email_txt.setText(email);
	                	tel_txt.setText(tel);
             	 
	    	     		editButton.addActionListener(new ActionListener() {
	    	     			public void actionPerformed(ActionEvent e) {
	    	     				Konnektor.stat_kunden_edit();
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

			Konnektor.stat_kunden_add();	
			}
		});
		addButton.setBounds(89, 327, 89, 23);
		contentPane.add(addButton);
		
		JButton deleteButton = new JButton("L\u00F6schen");
		deleteButton.setBackground(new Color(204, 255, 255));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Konnektor.stat_kunden_delete();

			}
		});
		deleteButton.setBounds(287, 327, 89, 23);
		contentPane.add(deleteButton);
		
		JButton updateButton = new JButton("Aktualisieren");
		updateButton.setBackground(new Color(204, 255, 255));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 a.setRowCount(0);
                 Konnektor.stat_kunden_update();
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
		

	}
}
