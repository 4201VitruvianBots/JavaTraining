import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost = 2;
		
		// You can modify these values if you wish
		int Chocolate = 4;
		int Poptarts = 2;
		int Chips = 0;
		int Chocolatewanted;
		int Poptartswanted;
		int Chipswanted;
		int cost;
		int totalMoney;
		int chocoInventory;
		int popInventory;
		int chipInventory;
		int amountAdded;
		int amountAdded2;
		int amountAdded3;
		
		while(true){
			switch(state){
			case 0: // waiting state; put string for admin mode and the money they need for the item
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost - currentMoney)) + " more.");
				String input = moneyInput.next();
				
	
				System.out.println("Chocolate");
				System.out.println("Poptarts");
				System.out.println("Chips");
				
				if(input.equals("Admin"))
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
			case 1: //item selection state and this where they select the item
				int itemSelection;
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item");
				
				
				System.out.println("Chose an item");
				System.out.println("1 = Chocolate");
				System.out.println("2 = Poptarts");
				System.out.println("3 = Chips");
				
				itemSelection = itemInput.nextInt();
				
				state = 2;
							
					break;
			case 2: //item check state (you can have a separate one for each item if you want)
					
				case 1: System.out.println("Your chocolate has been dropped");
					currentMoney = currentMoney - cost;
					state = 0; //this goes back to the waiting stage
					System.out.println("$" + current + "returned");
					currentMoney=0;
					
					System.out.println("Your Poptart has been dropped");
					currentMoney = currentMoney - cost;
					state = 0; //this goes back to the waiting stage
					System.out.println("$" + current + "returned");
					currentMoney=0;
					
					System.out.println("Your Chips has been dropped");
					currentMoney = currentMoney - cost;
					state = 0; //this goes back to the waiting stage
					System.out.println("$" + current + "returned");
					currentMoney=0;
					
					break;
			case 3: // Admin state
				
				System.out.println("You're now in Admin state!");
				
				System.out.println("How many chocolates do you want to add to the inventory?");
				chocoInventory = Chocolate + amountAdded;
				System.out.println(chocoInventory + "Chocolate");
				System.out.println(Chocolate "has been added to the inventory!");
				System.out.println("There a total of" + Chocolate + "chocolates" );

				System.out.println("How many poptarts do you want to add to the inventory?");
				popInventory = Poptarts + amountAdded2;
				System.out.println(chocoInventory + "Poptarts");
				System.out.println(Chocolate "has been added to the inventory!");
				System.out.println("There a total of" + Poptars + "poptarts" );
				
				System.out.println("How many chips do you want to add to the inventory?");
				chipInventory = Chips + amountAdded3;
				System.out.println(chipInventory + "chips");
				System.out.println(Chips "has been added to the inventory!");
				System.out.println("There a total of" + Chips + "chips" );
				
				if(input.equals("Wating"))
					state = 0;
				System.out.println("You're now out of Admin State and now in waiting mode");
				
			
				
			}
		}
		
	}
}
