import java.util.Scanner;

public class Elevator {
	public static void main(String[] args) {
		// Do not modify these variables
		int currentLocation = 0; // You can initialize this to any value you want
		int destination = 0;
		int floorMove = 0;
		Scanner input = new Scanner(System.in);
		
		while(true){ // This is so you can input multiple times without restarting the program
			System.out.println("Enter a destination: ");
			destination = input.nextInt(); // reads the input and set it as the destination
						
			// Begin writing your code here:
			// Clamp floor selection from 0 to 5 range
			if (destination >5 ) { 
				System.out.println("Floor seleceted too high, Floor 5 selected ");
				destination = 5;
			} else if (destination < 0) {
				System.out.println("Floor seleceted too low, Floor 0 selected ");
				destination = 0;
			} 
			
			floorMove = destination - currentLocation; //calculate how many floors to move
			System.out.println("The elevator is moving from Floor " + currentLocation + " to Floor " + destination);
			
			while( floorMove != 0 ) {   //Move up or down until desired floor reached
				if (floorMove > 0  ) {  //Move up
					floorMove = floorMove - 1;
					currentLocation = currentLocation +1;
					System.out.println("You have moved to Floor " + currentLocation);		
				} else if (floorMove < 0  ) {  //Move down
					floorMove = floorMove + 1;
					currentLocation = currentLocation - 1;
					System.out.println("You have moved to Floor " + currentLocation);
				} 
									
			}
			//Moves complete, report to console
			System.out.println("The elevator has arrived at the destination, Floor " + currentLocation);
		}
	}	   
}
