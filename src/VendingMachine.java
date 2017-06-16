import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		// Do not modify these values
		int state = 0;
		double currentMoney = 0;
		double itemCost = 2;
		int itemSelection = 0;
		// You can modify these values if you wish
		int item1 = 50;
		int item2 = 50;
		int item3 = 50;
		
		int amountWanted1 = 0;
		int amountWanted2 = 0;
		int amountWanted3 = 0;
		int amountAdded1 = 0;
		int amountAdded2 = 0;
		int amountAdded3 = 0;
		double totalCost = 0;
		double moreMoneyNeeded = 0;
		while(true){
			switch(state){
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//string moneyString = 
				System.out.println("Input Cash. You need $" + String.format("%.2f", (itemCost - currentMoney)) + " more.");
				System.out.println("There are " + item1 + " Root Beers left.");
				System.out.println("There are " + item2 + " Cokes left.");
				System.out.println("There are " + item3 + " Sprites left.");
				String input = moneyInput.next();
				
				if(input.equals("Admin"))
					//takes you to Admin mode
					state = 3;
				else{
					try{
						if (Double.valueOf(input) > 0){
							currentMoney += Double.valueOf(input);
							//Adds to current money
						}
						else{
							System.out.println("Please enter positive number.");
							//makes it so you can only put numbers in
						}						
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
						//makes it so you can only put numbers in
					}
				}
				
				if(currentMoney >= itemCost)
					//takes you to item selection
					state = 1;
				break;
			case 1: //item selection state
				
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item");
				System.out.println("1 = Root Beer");
				System.out.println("2 = Coke");
				System.out.println("3 = Sprite");
				System.out.println("0 = Eject money");
				itemSelection = itemInput.nextInt();
				
				state = 2;
							
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				state = 0;
				switch (itemSelection){
				case 0:
					System.out.println("$" + currentMoney + " returned");
					currentMoney = 0;
					break;
				case 1:
					System.out.println("How many Root Beers do you want?");
					Scanner itemAmount1 = new Scanner(System.in);
					amountWanted1 = itemAmount1.nextInt();
					totalCost=itemCost*amountWanted1;
					if (currentMoney>=itemCost * amountWanted1 && item1>=amountWanted1){
				 
					
						item1=item1-amountWanted1;
						amountWanted1=0;
						switch (amountWanted1){
						case 0:
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
						case 1:
							System.out.println("Item dispensed, enjoy your Root Beer!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
					
							break;
						default:
							System.out.println("Item(s) dispensed, enjoy your Root Beer(s)!");
							currentMoney=currentMoney-totalCost;
							state=0;
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
						}
					}
					else if (item1>=amountWanted1){
						moreMoneyNeeded = totalCost-currentMoney;
						System.out.println("$" + moreMoneyNeeded + " more needed.");
						state=0;
						System.out.println("$" + currentMoney + " returned");
						currentMoney=0;
					}
					else if (currentMoney>=itemCost){
						
						System.out.println("Only " + item1 + " left.");
						state=0;
						System.out.println("$" + currentMoney + " returned");
						currentMoney=0;
					}
				state = 0;
					break;
				case 2:
					System.out.println("How many Cokes do you want?");
					Scanner itemAmount2 = new Scanner(System.in);
					amountWanted2 = itemAmount2.nextInt();
					totalCost=itemCost*amountWanted2;
					if (currentMoney>=itemCost * amountWanted2 && item2>=amountWanted2){
				 
					
						item2=item2-amountWanted2;
						amountWanted2=0;
						switch (amountWanted2){
						case 0:
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
						case 1:
							System.out.println("Item dispensed, enjoy your Coke!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
							
						
						default:
								System.out.println("Item(s) dispensed, enjoy your Coke(s)!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
						}
					}
					else if (item2>=amountWanted2){
						moreMoneyNeeded = totalCost-currentMoney;
						System.out.println("$" + moreMoneyNeeded + " more needed.");
						state=0;
						System.out.println("$" + currentMoney + " returned");
						currentMoney=0;
					}
					else if (currentMoney>=itemCost){
						
						System.out.println("Only " + item1 + " left.");
						state=0;
						System.out.println("$" + currentMoney + " returned");
						currentMoney=0;
					}
					break;
				case 3:
					System.out.println("How many Sprites do you want?");
					Scanner itemAmount3 = new Scanner(System.in);
					amountWanted3 = itemAmount3.nextInt();
					totalCost=itemCost*amountWanted3;
					if (currentMoney>=itemCost * amountWanted3 && item3>=amountWanted3){
					
						item3=item3-amountWanted3;
						amountWanted3=0;
						
						switch (amountWanted3){
						case 0:
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
						case 1:
							System.out.println("Item dispensed, enjoy your Sprites!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
							
						
						default:
								System.out.println("Item(s) dispensed, enjoy your Sprite(s)!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + currentMoney + " returned");
							currentMoney=0;
							break;
							}
					}
					else if (item3>=amountWanted3){
						moreMoneyNeeded = totalCost-currentMoney;
						System.out.println("$" + moreMoneyNeeded + " more needed.");
						state=0;
						System.out.println("$" + currentMoney + " returned");
						currentMoney=0;
					}
					else if (currentMoney>=itemCost){
						
						
						System.out.println("Only " + item1 + " left.");
						state=0;
						System.out.println("$" + currentMoney + " returned");
						currentMoney=0;
					}
					
					break;
				default:
					System.out.println("invalid");
					System.out.println("$" + currentMoney + " returned");
					currentMoney=0;
					state = 0;
					break;
			}
				state = 0;
				break;
			case 3: // Admin state
				System.out.println("Admin mode activated.");
				System.out.println("How many Root Beers will you add?");
				Scanner Add1 = new Scanner(System.in);
				amountAdded1 = Add1.nextInt();
				item1+=amountAdded1;
				System.out.println(amountAdded1 + " Root Beers added.");
				System.out.println("There are now " + item1 + " Root Beers");
		
				System.out.println("How many Cokes will you add?");
				Scanner Add2 = new Scanner(System.in);
				amountAdded2 = Add2.nextInt();
				item2+=amountAdded2;
				System.out.println(amountAdded2 + " Cokes added.");
				System.out.println("There are now " + item2 + " Cokes.");
				
				System.out.println("How many Sprites will you add?");
				Scanner Add3 = new Scanner(System.in);
				amountAdded3 = Add3.nextInt();
				item3+=amountAdded3;
				System.out.println(amountAdded3 + " Sprites added.");
				System.out.println("There are now " + item3 + " Sprites.");
				System.out.println("Admin mode deactivated.");
				state = 0;
				break;
			}
		}		
	}
}	