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
			
			if (destination >5 ) {
				System.out.println("Floor seleceted too high, Floor 5 selected ");
				destination = 5;
			} else if (destination < 0) {
				System.out.println("Floor seleceted too low, Floor 0 selected ");
				destination = 0;
			} 
			
			floorMove = destination - currentLocation;
			System.out.println("The elevator is moving from Floor " + currentLocation + " to Floor " + destination);
			
			while( floorMove != 0 ) {
				if (floorMove > 0  ) {
					floorMove = floorMove - 1;
					currentLocation = currentLocation +1;
					System.out.println("You have moved to Floor " + currentLocation);		
				} else if (floorMove < 0  ) {
					floorMove = floorMove + 1;
					currentLocation = currentLocation - 1;
					System.out.println("You have moved to Floor " + currentLocation);
				} 
									
			}
			System.out.println("The elevator has arrived at the destination, Floor " + currentLocation);
		}
	}	   
}
