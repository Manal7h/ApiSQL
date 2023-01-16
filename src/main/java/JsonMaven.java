import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.*;
import com.google.gson.*;
import com.google.gson.*;
import com.google.*;


public class JsonMaven {	
	

		    


	public static void main(String[] args) throws IOException, InterruptedException {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=api;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    
		// TODO Auto-generated method stub
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://universities.hipolabs.com/search?country=United+States"))
                .build();// fetching the API
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("API JSON :" +response.body());
        String uglyJsonString=response.body();
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();//
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(uglyJsonString);
		String jsonString = gson.toJson(jsonElement);
		System.out.println(jsonString);
		
		Api[] ApiJson = gson.fromJson(jsonString, Api[].class);
		for (Api x : ApiJson) {
			
			String web_pages = x.getWeb_pages()[0];
			String state_province = x.getState_province();
			String alpha_two_code = x.getAlpha_two_code();
			String name= x.getName();
			String country = x.getCountry();
			String domian=x.getDomains()[0];
			
//			String SQLqueryForInserting="";
				

	
	        String SQLqueryForInserting = "insert into apaTable values('"+ web_pages +"' ,'" + state_province + "', '"+alpha_two_code+"','"+name+"' , '"+country+"' , '"+domian+"')";
	        
	 System.out.print(SQLqueryForInserting);
	        Connection con = null;
			
			

		    try {

		        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		        DriverManager.registerDriver(driver);
		        //con = DriverManager.getConnection(url, user, pass);

		        Statement st = con.createStatement();
		        
		     // Executing query
	            int m = st.executeUpdate(SQLqueryForInserting);
	            if (m >=  0)
	                System.out.println(
	                        "inserted successfully : " + SQLqueryForInserting);
	            else
	                System.out.println("insertion failed");

	            // Closing the connections
	            con.close();
	            
		    }
	            catch (Exception ex) {
	    	        // Display message when exceptions occurs
	    	        System.err.println(ex);
	    	    }
	    	    
	    	    }
		    }
		

	}


 