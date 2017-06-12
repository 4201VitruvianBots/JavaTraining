import java.util.Scanner;

public class Elevator {
	public static void main(String[] args) {
		// Do not modify these variables
		int currentLocation = 0; // You can initialize this to any value you want
		int destination = 0;
		Scanner input = new Scanner(System.in);

		while(true){ // This is so you can input multiple times without restarting the program
			System.out.println("Enter a destination: ");
			String inString = input.next(); // reads the input and set it as the destination
			try{ 
				destination = Integer.valueOf(inString);
			} 
			catch( Exception e ) {
				System.out.println("Invalid floor number.  Enter a number.");
				System.out.println("The elevator remains on floor " + currentLocation);
			}
			// Begin writing your code here:

			if( destination < 0 || destination > 5 ) {
				System.out.println("Invalid floor number.  Try between 0 and 5");
				System.out.println("The elevator remains on floor " + currentLocation);
				destination = currentLocation;
			} else 
			while( Math.abs(currentLocation - destination) > 0 ) {
				if( currentLocation < destination ) {
					currentLocation = goUp( currentLocation);
				} else if( currentLocation > destination ){
					currentLocation = goDown( currentLocation);
				} else break;
			}
			
			System.out.println("The elevator moved to floor " + currentLocation);
//			currentLocation = destination;
		}
//		input.close();
	}

	private static int goUp(int n) {
		System.out.println("Elevator moved UP from " + n);
		return(n+1);
	}
	private static int goDown(int n) {
		System.out.println("Elevator moved DOWN from " + n);
		return(n-1);
	}
}