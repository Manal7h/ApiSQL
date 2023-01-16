import java.io.IOException;
import java.util.Scanner;



public class JsonMaven {	
	
	static void MainMune(){
		
		System.out.println("Please Choice one Option:");
		
		System.out.println("1. Insert Into Hotels Table");
		
		
		System.out.println("                                 ");
		
		
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
			}	
		}
		while (true);

	}

}

 