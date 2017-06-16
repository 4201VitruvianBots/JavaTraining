import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost1 = 250;
		double itemCost2 = 8;
		double itemCost3 = 2;
		
		// You can modify these values if you wish
		int puppy = 1;
		int pizza = 4;
		int milkshake = 10;

		String itemSelection  = "";
		//test
		while(true){
			switch(state){
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost3 - currentMoney)) + " more.");
				String input = moneyInput.next();
				
				if(input.equals("Admin"))
					state = 3;
				else{
					try{
						currentMoney += Double.valueOf(input);
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
					}
				}
				
				if(currentMoney >= itemCost3)
					state = 1;
				break;
			case 1: //item selection state
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item. Your options are a puppy ($250), a pizza ($8), or a milkshake ($2).");
				itemSelection = itemInput.next();
				
				state = 2;
							
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				if(itemSelection.equals("puppy")){
					if(puppy > 0 && currentMoney >= 250){
						System.out.println("Puppies are in stock. The machine dispenses a puppy.");
						puppy--;
						double change = currentMoney - itemCost1;
						System.out.println("You recieve "+change+" back.");
						state = 0;
						currentMoney = 0;
					} else if(puppy >0){
						System.out.println("You don't have enough money for a puppy");
						state = 1;
					}
					else{
						System.out.println("There are no more puppies available.");
						state = 1;
					}
						
				}
				else if(itemSelection.equals("pizza")){
					if(pizza > 0 && currentMoney >= 8){
						System.out.println("Pizzas are in stock. The machine dispenses a pizza.");
						pizza--;
						double change = currentMoney - itemCost2;
						System.out.println("You recieve "+change+" back.");
						state = 0;
						currentMoney = 0;
					}else if(pizza > 0){
						System.out.println("You don't have enough money for a pizza");
						state = 1;
					}	
					else{
						System.out.println("There are no more pizzas available.");
						state = 1;
					}
						
				}
				else if(itemSelection.equals("milkshake")){
					if(pizza > 0 && currentMoney >= 2){
						System.out.println("Milkshakes are in stock. The machine dispenses a milkshake.");
						milkshake--;
						double change = currentMoney - itemCost3;
						System.out.println("You recieve "+change+" back.");
						state = 0;
						currentMoney = 0;
					}else if(milkshake > 0){
						System.out.println("You don't have enough money for a milkshake");
						state = 1;
					}
					else{
						System.out.println("There are no more milkshakes available.");
						state = 1;
					}
						
				}
				else {
					System.out.println("That is not being sold in this vending machine.");
					state = 1;
				}
				break;
			case 3: // Admin state
				System.out.println("What would you like to restock?");
				Scanner adminInput = new Scanner(System.in);
				String adminChoice = adminInput.next();
				if(adminChoice.equals("puppy")){
					System.out.println("How many puppies would you like to put in the vending machine?");
					int amount = adminInput.nextInt();
					puppy += amount;
					System.out.println(""+amount+" puppy(s) have been added to the vending machine.");
					}
				else if(adminChoice.equals("pizza")){
					System.out.println("How many pizzas would you like to put in the vending machine?");
					int amount = adminInput.nextInt();
					pizza += amount;
					System.out.println(""+amount+" pizza(s) have been added to the vending machine.");
					}
				else if(adminChoice.equals("milkshake")){
					System.out.println("How many milkshakes would you like to put in the vending machine?");
					int amount = adminInput.nextInt();
					milkshake += amount;
					System.out.println(""+amount+" milkshake(s) have been added to the vending machine.");
					}
				else if(adminChoice.equals("exit")) {
					System.out.println("Exiting admin.");
					state = 0;
				}
				else {
					System.out.println("That is not being sold in this vending machine.");
					
				}
				break;
			}
		}
		
	}
}
