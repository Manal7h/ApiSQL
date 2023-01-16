import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {

	public static void delete() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String url = "jdbc:sqlserver://localhost:1433;databaseName=api;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		
    Connection con = null;
    
    try {
    	
        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        DriverManager.registerDriver(driver);
        con = DriverManager.getConnection(url, user, pass);
        
        Statement st = con.createStatement();
        
        Scanner scanner=new Scanner(System.in);
        
    	System.out.println("Enter id that you want to delete: ");
    	
        int InputId =scanner.nextInt();
        
        int count=0;
        
        String sql ="DELETE FROM apaTable WHERE id = '"+ InputId +"'";
        
        
         int s =st.executeUpdate(sql);
        }
    
    
    catch (Exception ex) {
        System.err.println(ex);
    }
	}
	}


