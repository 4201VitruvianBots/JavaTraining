import java.util.Scanner;

public class Elevator {
	public static void main(String[] args) {
		// Do not modify these variables
		int currentLocation = 1; // You can initialize this to any value you want
		int destination = 0;
		Scanner input = new Scanner(System.in);
		try {
		
		while(true){ // This is so you can input multiple times without restarting the program
			System.out.println("Enter a destination: ");
			destination = input.nextInt(); // reads the input and set it as the destination
			
			// Begin writing your code here:
		while (currentLocation!=destination){
					if(currentLocation<=destination)
						currentLocation ++;
					else if(currentLocation>destination)
						 currentLocation--;
					System.out.println("The Elevator moved to floor " + currentLocation);
					if(destination >= 6)
						System.out.println("Location doesn't exist");
					if(destination <= 0)
						System.out.println("Location doesn't exist");

		}
				switch (currentLocation){
					case 5 :
						if (currentLocation == 5)
							System.out.println("Elevator is on floor 5");
						break;
					case 4 :
						if (currentLocation == 4)
							System.out.println("Elevator is on floor 4");
						break;
					case 3 :
						if (currentLocation == 3)
							System.out.println("Elevator is on floor 3");
						break;
					case 2 :
						if (currentLocation == 2)
							System.out.println("Elevator is on floor 2");
						break;
					case 1 :
						if (currentLocation == 1)
							System.out.println("Elevator is on floor 1");
						break;
						
				}							
		}
		
		
		}
		catch(Exception e) {
		System.out.println(e.getMessage());
				}
				
			
		}
	}

