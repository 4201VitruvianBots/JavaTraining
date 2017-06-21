import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost = 2;
		
		// You can modify these values if you wish
		int stock[] = {5, 3, 0};
		int maxItemIndex = stock.length;
		int itemSelection=-1;	// not valid
		
		while(true){
			String input="0";
//			String moneyString = "Input Cash. You need $" 
//					+ String.format("%.2f", (itemCost - currentMoney)) + " more.";
			switch(state){
			case 0: // waiting state;
				showCurrentInventory(stock);

				if(currentMoney >= itemCost) { 
					System.out.println("Sufficient funds: " + currentMoney);
					input = String.valueOf(0);
				} else 
				{
					System.out.println("Input Cash. You need $" 
							+ String.format("%.2f", (itemCost - currentMoney)) + " more.");
					Scanner moneyInput = new Scanner(System.in);
					input = moneyInput.next();
					// input = getInput 
				}
				
				if(input.equals("Admin"))
					state = 3;
				else{
					try{
						currentMoney += Double.valueOf(input);
//						currentMoney = getNewBalance(input);
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
					}
				}
				
				if(currentMoney >= itemCost)
					state = 1;
				break;
			case 1: //item selection state
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item");
				itemSelection = itemInput.nextInt();
				if( itemSelection < 1 || itemSelection > maxItemIndex ) {
					System.out.println("Invalid; enter item number between 1 and " + maxItemIndex);
					state = 1; 
					break;
				}
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
	
	private static double getNewBalance(String current) {
		return getRealNum() + Double.valueOf(current);
	}
	
	private static double getNewBalance(double current) {
		return getRealNum() + current;
	}
	
	private static double getRealNum() {
		double n = 0;
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		try{
			n = Double.valueOf(input);
		} catch(Exception e){
			System.out.println("Error: Invalid Input. Enter a number.");
		}
		scanner.close();
		return n;
	}
	
	private static void showCurrentInventory(int[] stock) {
//		switch(stock.length) {
//		case 1:
			System.out.println(
					"Available M&M=" + stock[0] 
							+ "; Gum=" + stock[1] 
							+ "; Nut=" + stock[2]);
	}
}
