		import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost = 2;
		double change = 0;
		// You can modify these values if you wish
		int Coke = 5;
		int Pepsi = 3;
		int Sprite = 0;
	
		String itemSelection = "";
		
		String input = "";
		while(true){
			switch(state){
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost - currentMoney)) + " more.");
				input = moneyInput.next();
				
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
			case 1: //item selection state
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item. Type in Coke, Sprite, or Pepsi");
				itemSelection = itemInput.next();			
				state = 2;
							
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				/*if (itemSelection.equals("Coke"))
				{
					Coke--;
					System.out.println("Yay Coke. Your Change is $" + change + ".");
					currentMoney = 0;
					change= currentMoney - itemCost; 
				}
				
				if (itemSelection.equals("Pepsi"))
				{
					Pepsi--;
					System.out.println("Yay Pepsi. Your Change is $" + change + ".");
					currentMoney = 0;
					change= ; 
				}
				*/
				state = 0;
				break;
				
						case 3: // Admin state
				System.out.println("A");
				state = 1;
				
			}
		}
		
	}
}
