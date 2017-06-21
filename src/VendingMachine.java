import java.util.Scanner;

public class VendingMachine {


	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost = 2;
		
		// You can modify these values if you wish
		int chocolate = 4;
		int poptarts = 2;
		int chips = 0;
		int chocolateWanted = 1;
		int poptartsWanted = 1;
		int chipsWanted = 1;
		int cost = 0;
		int totalMoney = 0;
		int chocoInventory = 0;
		int popInventory = 0;
		int chipInventory = 0;
		int amountAdded = 0;
		int amountAdded2 = 0;
		int amountAdded3 = 0;
		int itemSelection = 0;
		
		
		while(true){
			switch(state){
			case 0: // waiting state; put string for admin mode and the money they need for the item
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost - currentMoney)) + " more.");
				String input = moneyInput.next();
				
	
				
				
				if(input.equals("Admin"))
					state = 4;
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
					
					Scanner itemInput = new Scanner(System.in);
					System.out.println("Choose an item");
					
					
					
					System.out.println("1 = Chocolate");
					System.out.println("2 = Poptarts");
					System.out.println("3 = Chips");
					
					state = 2;
					itemSelection = itemInput.nextInt();
					break;
					
								
						
				case 2: //item check state (you can have a separate one for each item if you want)
			
					switch(itemSelection){
						case 1: System.out.println("Your chocolate has been dropped");
							currentMoney = currentMoney - cost;
							state = 0; //this goes back to the waiting stage
							currentMoney=0;
							break;
							
						case 2: System.out.println("Your poptart has been dropped");
							currentMoney = currentMoney - cost;
							state = 0; //this goes back to the waiting stage
							currentMoney=0;
							break;
							
						case 3:System.out.println("Your chips has been dropped");
							currentMoney = currentMoney - cost;
							state = 0; //this goes back to the waiting stage
							currentMoney=0;
							 break;
					}
					break;
					
					
				case 4: // Admin state, change it to be 
					Scanner adminInput = new Scanner(System.in);
					
					System.out.println("You're now in Admin state!");
					
					System.out.println("How many chocolates do you want to add to the inventory?");
					try{
						chocolate += adminInput.nextInt();
						System.out.println(chocoInventory + "Chocolate");
						System.out.println(chocolate + "has been added to the inventory!");
						System.out.println("There a total of" + chocolate + "chocolates" );
					}catch (Exception e){
						System.out.println("Invaild");
					}
	
					try{
						System.out.println("How many poptarts do you want to add to the inventory?");
						poptarts += adminInput.nextInt();
						System.out.println(chocoInventory + "Poptarts");
						System.out.println(poptarts + "has been added to the inventory!");
						System.out.println("There a total of" + poptarts + "poptarts" );
					}catch (Exception e){
						System.out.println("Invaild");
					}
						
					try{
						System.out.println("How many chips do you want to add to the inventory?");
						chips += adminInput.nextInt();
						System.out.println(chipInventory + "chips");
						System.out.println(chips + "has been added to the inventory!");
						System.out.println("There a total of" + chips + "chips" );
					} catch (Exception e){
						System.out.println("Invaild");
					}
				
//				if(input.equals("Waiting"))
					state = 0;
				System.out.println("You're now out of Admin State and now in waiting mode");
				
			
				
			
			} 
		}
	}
}

