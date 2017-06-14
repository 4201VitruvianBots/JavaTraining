import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost = 2;
		
		// You can modify these values if you wish
		int item1 = 5;
		int item2 = 3;
		int item3 = 0;
		int stock[] = {5, 3, 0};
		int itemSelection=-1;	// not valid
		
		while(true){
			switch(state){
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost - currentMoney)) + " more.");
				String input = moneyInput.next();
				
				if(input == "Admin")
					state = 3;
				else{
					try{
						currentMoney += Double.valueOf(input);
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
					}
				}
				
				if(currentMoney >= itemCost)
					state = 1;
				break;
			case 1: //item selection state
//				int itemSelection;
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item");
				itemSelection = itemInput.nextInt();
				// check inventory 
				System.out.println("You requested " + itemSelection); 
				state = 2;
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				if( stock[itemSelection-1] > 0 ) {
					System.out.println("Here is your item " + itemSelection);
					--stock[itemSelection-1];
					currentMoney -= itemCost;
					System.out.println("Here is your change " + currentMoney);
					state = 0;
				} else {
					System.out.println("Sorry we do not have " + itemSelection);
					state = 1;
				}
				break;
				
			case 3: // Admin state
				System.out.println("Hello Admin" + ". Nothing to do");
				break;
			}
		}
	}
}
