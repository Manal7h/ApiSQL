import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReadFromApi {

	public static void readFromApi()throws IOException, InterruptedException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=api;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    Scanner scanner = new Scanner(System.in);
	    
	    
	    System.out.print("Enter id That you want to show : ");
	    Integer insert = scanner.nextInt();
	    int count = 0;
	    String sql = " SELECT * FROM apaTable Where id ="+insert ;
	    
	    Connection con = null;
	    
	    try {

	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        con = DriverManager.getConnection(url, user, pass);

	        Statement st = con.createStatement();
	        
	        ResultSet result = st.executeQuery(sql); //ran the Q like sql
	        
	        while (result.next() && count < insert) {
				int id = result.getInt("id");
				String web_pages = result.getString("web_pages");
				String state_province = result.getString("state_province");
				String alpha_two_code = result.getString("alpha_two_code");
				String name = result.getString("name");
				String country = result.getString("country");
				String domian = result.getString("country");
				System.out.println(id + " " + web_pages + " " + state_province + " " + alpha_two_code + " " + name + " " + country + " " + domian);
				count++;
			}
			con.close();

	    }
        catch (Exception ex) {
	        // Display message when exceptions occurs
	        System.err.println(ex);
	    }
	}
		
		
		

		
		
		
		
	}

