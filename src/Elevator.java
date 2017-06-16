import java.util.Scanner;

public class Elevator {
	public static void main(String[] args) {
		// Do not modify these variables
		int currentLocation = 0; // You can initialize this to any value you want
		int destination = 0;
		
		while(true){ // This is so you can input multiple times without restarting the program
			System.out.println("Hi there. You're on floor 0 and your elavator can go to floor 5. Enter a destination: ");
			Scanner input = new Scanner(System.in);
			try{
			destination = input.nextInt(); // reads the input and set it as the destination
			
			// Begin writing your code here:
			switch(destination){
			case 0:
				if(destination == currentLocation){
					System.out.println("You are already on floor 0");
					
				} else{	
					if(currentLocation > destination){
						int distance = currentLocation - destination;
						System.out.println("You moved down " +distance +" floor(s).");
					}
					if(currentLocation < destination){
						int distance = destination - currentLocation;
						System.out.println("You moved up " +distance +" floor(s).");
					}
				}
				System.out.println("The elevator moved to floor " + destination);
				currentLocation = destination;
				break;
			case 1:
				if(destination == currentLocation){
					System.out.println("You are already on floor 1");
					
				} else{	
					if(currentLocation > destination){
						int distance = currentLocation - destination;
						System.out.println("You moved down " +distance +" floor(s).");
					}
					if(currentLocation < destination){
						int distance = destination - currentLocation;
						System.out.println("You moved up " +distance +" floor(s).");
					}
				}
				System.out.println("The elevator moved to floor " + destination);
				currentLocation = destination;
				break;
			case 2:
				if(destination == currentLocation){
					System.out.println("You are already on floor 2");
					
				} else{	
					if(currentLocation > destination){
						int distance = currentLocation - destination;
						System.out.println("You moved down " +distance +" floor(s).");
					}
					if(currentLocation < destination){
						int distance = destination - currentLocation;
						System.out.println("You moved up " +distance +" floor(s).");
					}
				}
				System.out.println("The elevator moved to floor " + destination);
				currentLocation = destination;
				break;
			case 3:
				if(destination == currentLocation){
					System.out.println("You are already on floor 3");
					
				} else{	
					if(currentLocation > destination){
						int distance = currentLocation - destination;
						System.out.println("You moved down " +distance +" floor(s).");
					}
					if(currentLocation < destination){
						int distance = destination - currentLocation;
						System.out.println("You moved up " +distance +" floor(s).");
					}
				}
				System.out.println("The elevator moved to floor " + destination);
				currentLocation = destination;
				break;
			case 4:
				if(destination == currentLocation){
					System.out.println("You are already on floor 4");
					
				} else{	
					if(currentLocation > destination){
						int distance = currentLocation - destination;
						System.out.println("You moved down " +distance +" floor(s).");
					}
					if(currentLocation < destination){
						int distance = destination - currentLocation;
						System.out.println("You moved up " +distance +" floor(s).");
					}
				}
				System.out.println("The elevator moved to floor " + destination);
				currentLocation = destination;
				break;
			case 5:
				if(destination == currentLocation){
					System.out.println("You are already on floor 5");
					
				} else{	
					if(currentLocation > destination){
						int distance = currentLocation - destination;
						System.out.println("You moved down " +distance +" floor(s).");
					}
					if(currentLocation < destination){
						int distance = destination - currentLocation;
						System.out.println("You moved up " +distance +" floor(s).");
					}
				}
				System.out.println("The elevator moved to floor " + destination);
				currentLocation = destination;
				break;
				
			default:
				if(destination > 5)
					System.out.println("You crashed into the ceiling.");
				if(destination < 0)
					System.out.println("You smashed into the ground.");
			}
			}catch(Exception e){
				System.out.println("That isn't a floor.");
				//break;
			}
		
		}
	}

}
