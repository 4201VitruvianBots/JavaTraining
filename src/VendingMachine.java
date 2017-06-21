import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost = 2;
		double money =  (itemCost - currentMoney);
		
		// You can modify these values if you wish
		int item1 = 5;
		int item2 = 3;
		int item3 = 0;
		
		
		while(true){
			switch(state){
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + money + " more.");
				String input = moneyInput.next();
				
				if(input == "Admin")
					state = 3;
				else{
					try{
						//currentMoney += double.valueOf(input);
						currentMoney = (currentMoney + money);
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
				
			case 3: // Admin state
				
			}
		}
		
	}
}
