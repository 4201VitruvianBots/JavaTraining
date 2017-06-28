import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Elevator {
	public static void main(String[] args) {
		// Do not modify these variables

		int currentLocation = 1; // You can initialize this to any value you want
		int destination = 0;

		double Button = 0;
		
		Scanner input = new Scanner(System.in);
	
		
		
		while(true){ // This is so you can input multiple times without restarting the program
			
			System.out.println("Enter a destination: ");
			
			
			String Buttons = input.next(); // reads the input and set it as the destination
			try{
				Button = Double.valueOf(Buttons);
			}catch (Exception e){
				System.out.println("Error");
			}
			
			if (Button == currentLocation){
			System.out.println("you are already there.")	;
			}
			
			
			else if (Button%2 == 0 || Button%2 == 1) {
					
				switch ((int)Button){
				case 1:
					destination = 1;
					break;
				case 2:
					destination = 2;
					break;
				case 3:
					destination = 3;
					break;
				case 4:
					destination = 4;
					break;
				case 5:
					destination = 5;
					break;
				case 6:
					destination = 6;
					break;
				case 7:
					destination = 7;
					break;
				case 8:
					destination = 8;
					break;
				case 9:
					destination = 9;
					break;
				case 10:
					destination = 10;
					break;
					
				default:
					System.out.println("That floor does not exist");
					break;
				}
				System.out.println("Your destination is " + destination);
				System.out.println("Your current location is " + currentLocation);
				while(currentLocation != destination && Button < 11 && Button >0){
					// Begin writing your code here:
					
					if (currentLocation<destination){
					currentLocation++;
					}
					else {
					currentLocation--	;
					}
					
					System.out.println("The elevator moved to floor " + currentLocation);
				
				}
				if (currentLocation == destination && Button < 11){
				currentLocation = destination;
				System.out.println("You have arrived at your destination.");
				}				
						
			}
			else {
				System.out.println("That floor does not exist.");
			}
			
		}
		
	}
	
}
