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
			
				switch(destination){
					case 1: currentLocation ++;
					System.out.println("Your Current Destination: 1 ");
						break;
					case 2: currentLocation +=2;
					System.out.println("Your elevator passed floor 1 ");
					System.out.println("Your Current Destination: 2 ");
						break;
					case 3: currentLocation +=3;
					System.out.println("Your elevator passed floor 1 ");
					System.out.println("Your elevator passed floor 2 ");
					System.out.println("Your Current Destination: 3 ");
						break;
					case 4: currentLocation +=4;
					System.out.println("Your elevator passed floor 1 ");
					System.out.println("Your elevator passed floor 2 ");
					System.out.println("Your elevator passed floor 3 ");
					System.out.println("Your Current Destination: 4 ");
						break;
					case 5: currentLocation +=5;
					System.out.println("Your elevator passed floor 1 ");
					System.out.println("Your elevator passed floor 2 ");
					System.out.println("Your elevator passed floor 3 ");
					System.out.println("Your elevator passed floor 4 ");
					System.out.println("Your Current Destination: 5 ");
						break;
					
				}
				if(destination > 5 ||destination < 0){
				System.out.println("Error 404: Floor Not Found! ");
				}
				else{
					System.out.println("The elevator moved to floor " + destination);
					currentLocation = destination;
				}
			
		}
	}

}
