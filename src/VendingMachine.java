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
		
		int itemSelection = -1;
		
		while(true){
			switch(state){
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost - currentMoney)) + " more. Type (x) to return change.");
				String input = moneyInput.next();
				
				//input == "Admin"
				if(input.equals("Admin"))
					state = 4;
				else if(input.equals("x"))
					state = 3;
				else {
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
				itemSelection = -1;
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item (1, 2, 3) or type (x) to return change.");
				String item = itemInput.next();
				
				if(item.equals("x"))
					state = 3;
				else{
					try{
						int inputSelection = Integer.valueOf(item);
						if(inputSelection >= 1 || inputSelection <= 3){
							itemSelection = inputSelection;
							state = 2;
						} else 
							System.out.println("Error: Invalid Item Selection");
						
					} catch(Exception e){
						System.out.println("Error: Invalid input");
					}
				}
							
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				boolean valid = false;
				switch(itemSelection){
				case 1:
					if(item1 > 0){
						valid = true;
						item1--;
					}
					break;
				case 2:
					if(item2 > 0){
						valid = true;
						item2--;
					}
					break;
				case 3:
					if(item3 > 0){
						valid = true;
						item3--;
					}
					break;
				}
				if(valid){
					currentMoney -= 2;
					System.out.println("Dispensed item " + itemSelection + ".");
					state = 3;
				}
				else{
					System.out.println("Item is out of stock.");
					state = 1;
				}
				break;
			case 3: // Return change state
				double change = currentMoney;
				currentMoney = 0;
				System.out.println("Returning $" + String.format("%.2f", (change)) + " in change.");
				state = 0;
				break;
			case 4: // Admin state
				System.out.println("Admin Mode.\nCurrent Stock:\nItem1: " + item1 +"\nItem2: "+ item2 + "\nItem3: "+ item3 + "\nSet the item and its quantity");
				Scanner adminInput = new Scanner(System.in);
				try{
					int adminSelect = adminInput.nextInt();
					int adminQuantity = adminInput.nextInt();
					switch(adminSelect){
					case 1:
						item1 = adminQuantity;
						break;
					case 2:
						item2 = adminQuantity;
						break;
					case 3:
						item3 = adminQuantity;
						break;
					}
					System.out.println("Set Item " + adminSelect + " to " + adminQuantity);
				} catch(Exception e){
					System.out.println("Error: Invalid Input");
				}
				break;
			}
		}
		
	}
}
