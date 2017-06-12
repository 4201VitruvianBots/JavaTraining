import java.util.Scanner;

public class Elevator {
	public static void main(String[] args) {
		// Do not modify these variables
		int currentLocation = 0; // You can initialize this to any value you want
		int destination = 0;
		Scanner input = new Scanner(System.in);
		
		while(true){ // This is so you can input multiple times without restarting the program
			System.out.println("Enter a destination: ");
			destination = input.nextInt(); // reads the input and set it as the destination
			
			// Begin writing your code here:
			
			//test2
			System.out.println("The elevator moved to floor " + destination);
			currentLocation = destination;
		}
	}

}
