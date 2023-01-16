import java.io.IOException;
import java.util.Scanner;



public class JsonMaven {	
	
	static void MainMune(){
		
		System.out.println("Please Choice one Option:");
		
		System.out.println("1. Insert Into api Table");
		
		
		System.out.println("                                 ");
		
		System.out.println("2. Read From api Table");
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		MainMune();

		do {
			
			int select = sc.nextInt();
			switch(select) {
			
			case 1:
				Insert insertFromApii = new Insert();
				insertFromApii.InsertFromApi();
				
				break;
				
			case 2:
			//ReadFromApi readFromApii = new ReadFromApi();
			ReadFromApi.readFromApi();
				
				break;	
			}	
		}
		while (true);

	}

}

 