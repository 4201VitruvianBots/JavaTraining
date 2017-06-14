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
		
		int itemSelection = 0;
		
		while(true){
			switch(state){
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost - currentMoney)) + " more.");
				String input = moneyInput.next();
				
				if(input.equals ("Admin"))
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
				
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item. Food = 1, Water = 2, and Shelter = 3.");
				itemSelection = itemInput.nextInt();
				
				state = 2;
							
				break;
			case 2: 
				
				if (itemSelection == 1)
				System.out.println("There are currently " + item1 + " units left.");
			
				else if (itemSelection == 2)
				System.out.println("There are currently " + item2 + " units left.");
				
				else if (itemSelection == 3)
					System.out.println("There are currently " + item3 + " units left.");
				else {
					System.out.println("Item doesn't exist"); 
				state = 1;}
			
				break;
	
			
			case 3: // Admin state (select an item and what item do you want to add)
				
				System.out.println("You are now in admin. Please select an item."); 
				Scanner choiceInput = new Scanner(System.in);
				itemSelection = choiceInput.nextInt(); 
				System.out.println("You selected this item. How much of this item do you want to input?");
				Scanner quantityInput = new Scanner(System.in);
				if(itemSelection == 1)
					item1 = quantityInput.nextInt();
				System.out.println("This item now has" + item1 + "units.");
				
				
				if(itemSelection == 2)
					item2 = quantityInput.nextInt();
				System.out.println("This item now has" + item2 + "units.");
				
				if(itemSelection == 3)
					item3 = quantityInput.nextInt();	
				System.out.println("This item now has" + item3 + "units.");
				state = 5;
				break;
			}
		}
		
	}
}
