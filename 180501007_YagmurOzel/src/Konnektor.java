import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
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

	public static void main(String[] args) {

		Konnektor x = new Konnektor();
		x.conn();
}
}