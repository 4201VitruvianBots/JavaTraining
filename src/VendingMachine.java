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
				change = 0;
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
				System.out.println("Choose an item. Type in Coke, Sprite, or Pepsi. Type x to return change.");
				itemSelection = itemInput.next();			
				state = 2;
							
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				if (itemSelection.equals("Coke"))
				{
					
					if (Coke > 0){
						Coke--;
						System.out.println("Yay Coke. Your Change is $" + change + ".");
						change= currentMoney - itemCost;
						currentMoney = 0;	
						state = 0;
					}
					else {
						System.out.println("Sorry. "+"No Coke Left.");
						state = 1;
						//change = currentMoney; 
						
					}
					
						
				}
				
				if (itemSelection.equals("Pepsi"))
				{
					if (Pepsi > 0){
						Pepsi--;
						System.out.println("Yay Pepsi. Your Change is $" + change + ".");
						change= currentMoney - itemCost;
						currentMoney = 0;	
						state = 0;
					}
					else {
						System.out.println("Sorry. "+"No Pepsi Left.");
						state = 1;
						//change = currentMoney; 
						
					}
				}
				
				if (itemSelection.equals("Sprite"))
				{
					if (Sprite > 0){
						Sprite--;
						System.out.println("Yay Sprite. Your Change is $" + change + ".");
						change= currentMoney - itemCost;
						currentMoney = 0;	
						state = 0;
					}
					else {
						System.out.println("Sorry. "+"No Sprite Left.");
						state = 1;
						//change = currentMoney; 
						
					}
				}
				
				if (itemSelection.equals("x")){
					System.out.println("Here is your change $" + currentMoney + ". Come Again.") ; 
					state = 0; 
					currentMoney=0;
				}

				break;
				
				case 3: // Admin state
						System.out.println("A. Please Select Coke, Pepsi or Sprite.");
						Scanner adminInput = new Scanner(System.in);
						itemSelection = adminInput.next();
						
						if (itemSelection.equals("Coke"))
						{
							System.out.println("Please Enter a Quantity");
							boolean test = true;
							while(test)
							{
								try
								{
									int amount = adminInput.nextInt();
									test = false;
									Coke = amount;
									System.out.println("The amount of Coke is now " + amount );
								}
								catch(Exception e)
								{
									System.out.println("Please input a number.");
								}
							}
						}
						
						if (itemSelection.equals("Pepsi"))
						{
							System.out.println("Please Enter a Quantity");
							boolean test = true;
							while(test)
							{
								try
								{
									int amount = adminInput.nextInt();
									test = false;
									Pepsi = amount;
									System.out.println("The amount of Pepsi is now " + amount );
								}
								catch(Exception e)
								{
									System.out.println("Please input a number.");
								}
							}
						}
						
						if (itemSelection.equals("Sprite"))
						{
							System.out.println("Please Enter a Quantity");
							boolean test = true;
							while(test)
							{
								try
								{
									int amount = adminInput.nextInt();
									test = false;
									Sprite = amount;
									System.out.println("The amount of Sprite is now " + amount );
								}
								catch(Exception e)
								{
									System.out.println("Please input a number.");
								}
							}
						}
						
						if (itemSelection.equals("z"))
							state=0;
						
						break;
				
			}
		}
		
	}
}
