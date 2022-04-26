import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Konnektor {

	public static void main(String[] args) {
		
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reinigung","root", "12341234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = ((java.sql.Statement) myStat).executeQuery("select * from produkt");
			while(myRs.next()) {
				System.out.print(myRs.getString("Produkt_id") + "-" + myRs.getString("Name") + myRs.getString("Kosten"));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
