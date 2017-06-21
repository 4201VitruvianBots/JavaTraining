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
					state = 7;
				
				else{
					try{
						double money = Double.parseDouble(input);
						currentMoney += money;
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
					}
				}
				break;
			
			case 1: //item selection state
				
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Input a number for candy. Skittles = 1, Gummy Bears = 2, and Twix = 3.");
				itemSelection = itemInput.nextInt();
				switch(itemSelection){
					case 1: 
						state = 2;
						break;
					case 2: 
						state = 3;
						break;
					case 3: 
						state = 4;
						break;
					default : 
						state = 5;
						break;
					}
				
							
				break;
				
				case 2:
				
				System.out.println("Right now there are " + item1 + " packets of Skittles.");
				
				System.out.println("With your purchase, there are now " + ((--item1)) + " packets left.");
				currentMoney = currentMoney - itemCost;
				currentMoney=0;
						
				state = 0;
				
				break; 
				
			case 3: 
				
					System.out.println("Right now there are " + item2 + " packets of Gummy Bears.");
					
					System.out.println("With your purchase, there are now " + ((--item2)) + " packets left.");
					currentMoney = currentMoney - itemCost;
					currentMoney=0;
				state = 0;
				
				break;
				
			case 4:

					System.out.println("There are currently " + item3 + " bars of Twix left.");
				currentMoney = currentMoney - itemCost;
				currentMoney=0;
				state = 0;
				
				break;
				
			case 5:	
				
				if (itemSelection >= 4 || itemSelection <= 0) 
					System.out.println("There isn't any candy with the following inputted number."); 
				
				state = 1;
				
				break;
				
			case 7: // Admin state (select an item and what item do you want to add)
				
				
				System.out.println("You are now in admin. Please select an item."); 
					Scanner choiceInput = new Scanner(System.in);
					itemSelection = choiceInput.nextInt(); 
					
				System.out.println("You selected this item. How much of this item do you want to input?");
					Scanner quantityInput = new Scanner(System.in);
					
				if(itemSelection == 1){
					item1 += quantityInput.nextInt();
				System.out.println("This item now has " + item1 + " packets.");
				
					state = 0;
				}
				else if(itemSelection == 2){
					item2 += quantityInput.nextInt();
					System.out.println("This item now has " + item2 + " packets.");
				
					state = 0;
				}
				else if(itemSelection == 3){
					item3 += quantityInput.nextInt();	
					System.out.println("This item now has " + item3 + " packets.");
					
					state = 0;
				}
				else if(itemSelection >=4 || itemSelection<=0) {
					item3 = quantityInput.nextInt();	
					System.out.println("Item is invalid.");
				}
				break;
				}
			}
		}
}
