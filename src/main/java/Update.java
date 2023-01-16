import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Update {

	public static void update() throws IOException, InterruptedException{
		String url = "jdbc:sqlserver://localhost:1433;databaseName=api;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		
		
		String sql = "UPDATE apaTable SET web_pages = ?, state_province = ? ,alpha_two_code = ?, name = ? , country = ? , domains = ? WHERE id = ?";
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("Enter the id of the row to update: ");
		int id = scanner.nextInt();
		
		Connection con = null;
	
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			
			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "http://www.sjrstate.edu/");
			pstmt.setString(2, "101");
			pstmt.setString(3, "OMR");
			pstmt.setString(4, "Manal");
			pstmt.setString(5, "ALKABOURA");
			pstmt.setString(6, "uopeople.edu");		
			pstmt.setInt(7, id);
			
			
			pstmt.executeUpdate();
			String sql2 = "SELECT * FROM apaTable WHERE id = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			
			pstmt2.setInt(1, id);
			
			ResultSet result = pstmt2.executeQuery();
			if (result.next()) {
				
				String web_pages = result.getString("web_pages");
				String state_province = result.getString("state_province");
				String alpha_two_code = result.getString("alpha_two_code");
				String name = result.getString("name");
				String country = result.getString("country");
				String domains = result.getString("domains");
				System.out.println(id + " " + web_pages + " " + state_province + " " + alpha_two_code + " " + name + " " + country + " " + domains);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	

	}


