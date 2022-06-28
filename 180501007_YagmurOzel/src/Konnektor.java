import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;



public class Konnektor extends JFrame {
	static Connection myConn;
	static Statement myStat;


	
	public void conn() {
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinigung","root", "12341234");
			System.out.println("Verbindung erfolgreich");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
	static ResultSet stat_produkt(){
		ResultSet myRs = null;
		try {
			myStat = (Statement) myConn.createStatement ();
			myRs = myStat.executeQuery("SELECT * FROM produkt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;		
	}

	static ResultSet stat_kunden(){
		ResultSet myRs = null;
		try {
			myStat = (Statement) myConn.createStatement ();
			myRs = myStat.executeQuery("SELECT * FROM kunden");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;		
	}

	static ResultSet stat_login(){
		ResultSet myRs = null;
		try {
			myStat = (Statement) myConn.createStatement ();
			myRs = myStat.executeQuery("SELECT * FROM user");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;		
	}
	
	static ResultSet stat_loginUser(){
		
		String username = LoginFrame.userField.getText();
		String password = LoginFrame.passwordField_1.getText();

		ResultSet myRs = null;
		try {
			PreparedStatement st = (PreparedStatement) myConn
					.prepareStatement("SELECT username, password FROM user WHERE username=? AND password=?");
			
			st.setString(1, username);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
            if (rs.next()) {
                //dispose();
                
                ProduktFrame pf = new ProduktFrame();
        	    KundenFrame kf = new KundenFrame();
        	    AdminFrame af = new AdminFrame();
        	    KDienstMenuFrame df = new KDienstMenuFrame();
        	    ReinigungFrame rf = new ReinigungFrame();
              
        	    switch (username) {
			case "admin": {
				af.setTitle("Willkommen");
                af.setVisible(true);
                JOptionPane.showMessageDialog(LoginFrame.btnNewButton, "Sie haben sich erfolgreich mit den Referenzen ADMIN angemeldet");
				break;
			
			}
			case "kundendienst":{
				df.setTitle("Willkommen");
                df.setVisible(true);
                JOptionPane.showMessageDialog(LoginFrame.btnNewButton, "Sie haben sich erfolgreich mit den Referenzen KUNDENDIENST angemeldet");
                break;
			}
			case "buchhalter" :{
				pf.setTitle("Willkommen");
                pf.setVisible(true);
                JOptionPane.showMessageDialog(LoginFrame.btnNewButton, "Sie haben sich erfolgreich mit den Referenzen BUCHHALTER angemeldet");
                break;
				
			}
			case "reinigung" :{
				rf.setTitle("Welcome");
                rf.setVisible(true);
				
               JOptionPane.showMessageDialog(LoginFrame.btnNewButton, "Sie haben sich erfolgreich mit den Referenzen REINIGUNGSDIENST angemeldet");
                break;
				
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + username);
			}
                
                
            } else {
                JOptionPane.showMessageDialog(LoginFrame.btnNewButton, "Falscher Benutzername / Passwort");
			
			
            }
			
		} 
		   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;	
		
	}


	static ResultSet stat_res(){

		ResultSet myRs = null;
		try {
			myStat = (Statement) myConn.createStatement ();
			myRs = myStat.executeQuery("SELECT * FROM reservation");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;	
		
		
		
	}

	static ResultSet stat_kunden_delete(){

		
		String user_TC = KundenFrame.tc_txt.getText();
		
		ResultSet myRs = null;
		Statement stmt;
		try {
			stmt = myConn.createStatement();
			
			String delete = "DELETE FROM kunden WHERE Kunden_TC = '"+user_TC+"'";
			int x = stmt.executeUpdate(delete);
			if (x > 0)
				JOptionPane.showMessageDialog(KundenFrame.deleteButton,"Erfolgreich gelöscht. Bitte AKTUALISIEREN-BUTTON verwenden!");
            else
            	JOptionPane.showMessageDialog(KundenFrame.deleteButton,"Löschen fehlgeschlagen");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return myRs;
	}
	
	static ResultSet stat_kunden_edit(){
		ResultSet myRs = null;
		
			Statement stmt;
            try {
                stmt = myConn.createStatement();
                String edit = "UPDATE kunden SET Vorname = '"+KundenFrame.vorn_txt.getText()+"' , Nachname = '"+KundenFrame.nach_txt.getText()+"', email = '"+KundenFrame.email_txt.getText()+"', telefonnummer = '"+KundenFrame.tel_txt.getText()+"'"
                		+ " WHERE Kunden_TC = '"+KundenFrame.tc_txt.getText()+"'";
                int x = stmt.executeUpdate(edit);
                if (x > 0)
                    JOptionPane.showMessageDialog(KundenFrame.editButton,"Erfolgreich bearbeitet. Bitte AKTUALISIEREN-BUTTON verwenden!");
                else
                    JOptionPane.showMessageDialog(KundenFrame.editButton,"Bearbeitung fehlgeschlagen");

               

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		return myRs;		
	}
	
	static ResultSet stat_kunden_update(){
	     ResultSet myRs = null;
		 ResultSet myRs2 = stat_kunden();
		 try {
            while(myRs2.next()) {
                KundenFrame.rows[0] = myRs2.getString("Kunden_TC");    
                KundenFrame.rows[1] = myRs2.getString("Vorname");
                KundenFrame.rows[2] = myRs2.getString("Nachname");
                KundenFrame.rows[3] = myRs2.getString("email");
                KundenFrame.rows[4] = myRs2.getString("telefonnummer");

                KundenFrame.a.addRow(KundenFrame.rows);
            }

            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		return myRs;		
	}
    
	static ResultSet stat_kunden_add(){
		ResultSet myRs = null;
		String user_TC = KundenFrame.tc_txt.getText();
		String vorname = KundenFrame.vorn_txt.getText();
		String nachname = KundenFrame.nach_txt.getText();
		String email = KundenFrame.email_txt.getText();
		String tel = KundenFrame.tel_txt.getText();

		Statement stmt;
		try {
			stmt = myConn.createStatement();
			
			String insert = "INSERT INTO kunden (`Kunden_TC`, `Vorname`, `Nachname`, `email`, `telefonnummer`) VALUES "
					+ "('"+user_TC+"', '"+vorname+"','"+nachname+"','"+email+"','"+tel+"')";
			int x = stmt.executeUpdate(insert);
			if (x > 0)
				JOptionPane.showMessageDialog(KundenFrame.addButton,"Erfolgreich eingefügt. Bitte AKTUALISIEREN-BUTTON verwenden!");
            else
            	JOptionPane.showMessageDialog(KundenFrame.addButton,"Einfügen fehlgeschlagen");


			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return myRs;		
	}

	static ResultSet stat_reinigung_update(){
		ResultSet myRs = null;
		ResultSet myRs2 = stat_res();
		 try {
            while(myRs2.next()) {
                ReinigungFrame.rows[0] = myRs2.getString("Reservations_Nr");    
                ReinigungFrame.rows[1] = myRs2.getString("Kunden_TC");
                ReinigungFrame.rows[2] = myRs2.getString("Date");
                ReinigungFrame.rows[3] = myRs2.getString("Produkt");
                ReinigungFrame.rows[4] = myRs2.getString("Situation");
                
                ReinigungFrame.b.addRow(ReinigungFrame.rows);
            }

            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		return myRs;		
	}
	

	static ResultSet stat_produkt_edit(){
		ResultSet myRs = null;
			Statement stmt;
			
			 int selected_row = ProduktFrame.table.getSelectedRow();
			String produkt_id = ProduktFrame.table.getValueAt(selected_row,0).toString();
            try {
                stmt = myConn.createStatement();
                String edit = "UPDATE produkt SET Kosten = '"+ProduktFrame.kosten_txt.getText()+"'WHERE Produkt_id = '"+produkt_id+"'";
                int x = stmt.executeUpdate(edit);
                if (x > 0)
                    JOptionPane.showMessageDialog(ProduktFrame.editButton,"Erfolgreich bearbeitet. Bitte AKTUALISIEREN-BUTTON verwenden!");
                else
                    JOptionPane.showMessageDialog(ProduktFrame.editButton,"Bearbeitung fehlgeschlagen");

               

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
		return myRs;		
	}
	
	static ResultSet stat_produkt_update(){
		ResultSet myRs = null;
		ResultSet myRs2 = stat_produkt();
		 
		 try {
            while(myRs2.next()) {
                ProduktFrame.rows[0] = myRs2.getString("Produkt_id");
                ProduktFrame.rows[1] = myRs2.getString("Name");
                ProduktFrame.rows[2] = myRs2.getString("Kosten");
               
                ProduktFrame.y.addRow(ProduktFrame.rows);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		return myRs;		
	}
	
	static ResultSet stat_res_update(){
		ResultSet myRs = null;
		ResultSet myRs2 = stat_res();
		 try {
            while(myRs2.next()) {
                ResFrame.rows[0] = myRs2.getString("Reservations_Nr");    
                ResFrame.rows[1] = myRs2.getString("Kunden_TC");
                ResFrame.rows[2] = myRs2.getString("Date");
                ResFrame.rows[3] = myRs2.getString("Produkt");
                ResFrame.rows[4] = myRs2.getString("Situation");

                ResFrame.b.addRow(ResFrame.rows);
            }

            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		return myRs;		
	}
	
	static ResultSet stat_res_abfrage(){
		ResultSet myRs = null;
		String user_TC = ResFrame.textFieldTC.getText();
		
		ResultSet myRs2;
		Statement stmt;
		
		try {
			stmt = myConn.createStatement();
			myRs2 = stmt.executeQuery("SELECT * FROM reservation WHERE Kunden_TC = '"+user_TC+"'");
			
			for (int i = 0; i < ResFrame.rows.length; i++) {
				 if(myRs2.next()) {
                ResFrame.rows[0] = myRs2.getString("Reservations_Nr");    
                ResFrame.rows[1] = myRs2.getString("Kunden_TC");
                ResFrame.rows[2] = myRs2.getString("Date");
                ResFrame.rows[3] = myRs2.getString("Produkt");
                ResFrame.rows[4] = myRs2.getString("Situation");

                ResFrame.b.addRow(ResFrame.rows)
                ;}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return myRs;		
	}
	
	static ResultSet stat_res_delete(){
		ResultSet myRs = null;
		String user_TC = ResFrame.tc_txt.getText();
		String res_num = ResFrame.res_txt.getText();
		String date = ResFrame.date_txt.getText();

		Statement stmt;
		try {
			stmt = myConn.createStatement();
			
			String delete = "DELETE FROM reservation WHERE Reservations_Nr = '"+res_num+"'";
			int x = stmt.executeUpdate(delete);
			if (x > 0)
				JOptionPane.showMessageDialog(ResFrame.deleteButton,"Erfolgreich gelöscht. Bitte AKTUALISIEREN-BUTTON verwenden!");
            else
            	JOptionPane.showMessageDialog(ResFrame.deleteButton,"Löschen fehlgeschlagen");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return myRs;		
	}

	static ResultSet stat_res_add(){
		ResultSet myRs = null;
		
		int selected_row = ResFrame.table.getSelectedRow();
		String user_TC = ResFrame.tc_txt.getText();
		String res_num = ResFrame.res_txt.getText();
		String date = ResFrame.date_txt.getText();
		String produkt = ResFrame.table.getValueAt(selected_row,3).toString();
		ResFrame.comboBox.setSelectedItem(produkt);
		
	
		
		

		Statement stmt;
		try {
			stmt = myConn.createStatement();
			
			String insert = "INSERT INTO reservation ( `Reservations_Nr`,`Kunden_TC`, `Date`, `Produkt`) VALUES "
					+ "('"+res_num+"', '"+user_TC+"','"+date+"','"+produkt+"')";
			int x = stmt.executeUpdate(insert);
			if (x > 0)
				JOptionPane.showMessageDialog(ResFrame.addButton,"Erfolgreich eingefügt. Bitte AKTUALISIEREN-BUTTON verwenden!");
            else
            	JOptionPane.showMessageDialog(ResFrame.addButton,"Einfügen fehlgeschlagen");


			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return myRs;		
	}
	
	public static void main(String[] args) {

		Konnektor x = new Konnektor();
		x.conn();
}
}