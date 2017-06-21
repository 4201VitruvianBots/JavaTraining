import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
			if(destination > 5 || destination <= 0){
				System.out.println("The floor does not exist!");
			}
			else if(destination <=5 && destination > 0){
				System.out.println("Your chosen destination is floor " + destination);
			}
			else if(destination == currentLocation){
				System.out.println("You have reached your destination.");
			}
			else {
				System.out.println("error!");
			}
			
			if(destination <=5 && destination > 0) {
			
			for (currentLocation = 1; currentLocation <= destination; currentLocation++) {
				
				switch(currentLocation) {
					case 1:
						System.out.println("The elevator is currently on floor 1");
						TimeUnit.SECONDS.toSeconds(1);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
		
					case 2:
						System.out.println("The elevator is currently on floor 2");
						TimeUnit.SECONDS.toSeconds(1);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 3:
						System.out.println("The elevator is currently on floor 3");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					
					case 4:
						System.out.println("The elevator is currently on floor 4");
						TimeUnit.SECONDS.toSeconds(3);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 5:
						System.out.println("The elevator is currently on floor 5");
						TimeUnit.SECONDS.toSeconds(3);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					default: break;
					
					}//switch
				if(currentLocation == destination){
					System.out.println("You have arrived at your destination!");
				}
			  } // for
			}//if
		}
	}

	private static Object destination(int i) {
		// TODO Auto-generated method stub
		return null;
	}//main
}//class
