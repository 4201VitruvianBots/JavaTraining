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
		while(currentLocation!=destination){
			if(currentLocation<=destination){
				currentLocation++;
				System.out.println("Elevator moves to floor " + currentLocation);
				}
				else if(currentLocation>destination)
					currentLocation--;
			if(destination>5 && destination<0);
				System.out.println("This floor does not exist.");
		}
		switch(currentLocation){
		case 0:
			if(currentLocation == 0)
				System.out.println("Elevator arrives at the ground floor.");
			else if(currentLocation<0);
				System.out.println("This floor does not exist.");
			break;
		case 1:
			if(currentLocation == 1);
				System.out.println("Elevator arrives at floor 1");
		break;
		case 2:
			if(currentLocation == 2);
				System.out.println("Elevator arrives at floor 2");
		break;
		case 3:
			if(currentLocation == 3);
				System.out.println("Elevator arrives at floor 3");
		break;
		case 4:
			if(currentLocation == 4);
				System.out.println("Elevator arrives at floor 4");
		break;
		case 5:
			if(currentLocation == 5);
				System.out.println("Elevator arrives at floor 5");
		break;
		}
		}
			}
		}