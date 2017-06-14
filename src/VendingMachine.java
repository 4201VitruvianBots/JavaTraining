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
				int itemSelection;
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item");
				itemSelection = itemInput.nextInt();
				
				state = 2;
							
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				
				try{
				if(itemInput == item1);
					(item1 >= 1) ? System.out.println("Item1 has been selected. Please collect your item.") && item1-- : System.out.println("Not enough of item1 in stock. Please select again.") && state = 1
				} catch(Exception e){
					System.out.println("Error: item1 not in stock");
				}
				try{
				if(itemInput == item2);
					(item2 >= 1) ? System.out.println("Item2 has been selected. Please collect your item.") && item2-- : System.out.println("Not enough of item2 in stock. Please select again.") && state = 1
				} catch(Exception e){
					System.out.println("Error: item2 not in stock");
				}
				try{
				if(itemInput == item2);
					(item3 >= 1) ? System.out.println("Item3 has been selected. Please collect your item.") && item3-- : System.out.println("Not enough of item3 in stock. Please select again.") && state = 1
				} catch(Exception e){
					System.out.println("Error: item3 not in stock");
				}				
				break;
			case 3: // Admin state
				
			}
		}
		
	}
}
