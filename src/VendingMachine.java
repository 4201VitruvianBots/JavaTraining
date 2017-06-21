import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		
		int state = 0; //where you are in the code
		double currentMoney = 0; //money in machine
		double itemCost1 = 10, itemCost2 = 100, itemCost3 = 0.50; //sets price
		int itemSelection = 0; //selects what you buy
		int item1 = 100, item2 = 25, item3 = 1000;  //sets amount
		int amountWanted1 = 0, amountWanted2 = 0, amountWanted3 = 0; //makes it so you can get more than 1
		int amountAdded1 = 0, amountAdded2 = 0, amountAdded3 = 0; //lets you add in Admin mode
		double totalCost = 0; //total cost of purchase
		int adminSetting = 1; //sets location in Admin mode
		
		while(true){
			switch(state){
			//sets mode
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//informs user
				System.out.println("Fidget Spinners cost $" + String.format("%.2f", (itemCost1)));
				System.out.println("Drones cost $" + String.format("%.2f", (itemCost2)));
				System.out.println("Bouncy balls cost $" + String.format("%.2f", (itemCost3)));
				System.out.println("Input Cash. You need at least $" + String.format("%.2f", (itemCost3 - currentMoney)) + " more.");
				System.out.println("There are " + item1 + " Fidget Spinners left.");
				System.out.println("There are " + item2 + " Drones left.");
				System.out.println("There are " + item3 + " bouncy balls left.");
				String input = moneyInput.next();
				if(input.equals("Admin"))
					//takes you to Admin mode
					state = 3;
				else if(input.equals("Sample") && item1>0 && item2>0 && item3>0){
					//gives you things for free
					System.out.println("Enjoy your fidget spinner.");
					System.out.println("Enjoy your drone.");
					System.out.println("Enjoy your ball.");
					item1 --;
					item2 --;
					item3 --;
					state = 0;
				}
				else if(input.equals("Sample")){
					System.out.println("More supplies needed.");
				}
				else {
					try{
						if (Double.valueOf(input) >= 0){
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
				
				if(currentMoney >= itemCost3)
					//takes you to item selection
					state = 1;
				break;
			case 1: //item selection state
				
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item");
				System.out.println("1 = Fidget spinner");
				System.out.println("2 = Drone");
				System.out.println("3 = Bouncy ball");
				System.out.println("0 = Eject money");
				try{
					itemSelection = itemInput.nextInt();
					state = 2;
				}catch(Exception e){
					System.out.println("Error: Invalid Input");
					//makes it so you can only put numbers in
					state = 1;					
				}			
				break;
			case 2: //item check state (you can have a separate one for each item if you want)
				state = 0;
				switch (itemSelection){
				case 0:
					System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
					currentMoney = 0;
					break;
					//makes it so you can't ask for 0
				case 1:
					System.out.println("How many fidget spinners do you want?");
					Scanner itemAmount1 = new Scanner(System.in);
					try{amountWanted1 = itemAmount1.nextInt();
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
						//makes it so you can only put numbers in						
					}
					totalCost=itemCost1*amountWanted1; 
					if (currentMoney>=totalCost && item1>=amountWanted1){
				 
					
						item1-=amountWanted1;
						switch (amountWanted1){
						//changes grammar
						case 0:
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						default:
							System.out.println("Item"+(amountWanted1 > 1? "s" :"")+ " dispensed, enjoy your fidget spinner"+(amountWanted1 > 1? "s" :"")+"!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						}
					}
					else if (item1>=amountWanted1){
						//makes sure you have enough money
						System.out.println("$" + String.format("%.2f", totalCost)+ " needed.");
						state=1;
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
					}
					else {						
						//makes sure there is enough of the product
						System.out.println("Only " + item1 + " left.");
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
						state = 0;
					}
					break;
				case 2:
					System.out.println("How many drones do you want?");
					Scanner itemAmount2 = new Scanner(System.in);
					try{amountWanted2 = itemAmount2.nextInt();
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
						//makes it so you can only put numbers in						
					}
					totalCost=itemCost2*amountWanted2;
					if (currentMoney>=totalCost && item2>=amountWanted2){			
						item2=item2-amountWanted2;
						
						switch (amountWanted2){
						//changes grammar
						case 0:
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						default:
							System.out.println("Item" +(amountWanted2 > 1? "s" :"")+ " dispensed, enjoy your drone" +(amountWanted2 > 1? "s" :"")+ "!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						}
					amountWanted2=0;
					}
					else if (item2>=amountWanted2){
						//makes sure you have enough money
						System.out.println("$" + String.format("%.2f", totalCost)+ " needed.");
						state=0;
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
					}
					else {
						//makes sure there is enough of the product
						System.out.println("Only " + item2 + " left.");
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
						state = 0;
					}
					break;
				case 3:
					System.out.println("How many bouncy balls do you want?");
					Scanner itemAmount3 = new Scanner(System.in);
					try{amountWanted3 = itemAmount3.nextInt();
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
						//makes it so you can only put numbers in
					}
					totalCost=itemCost3*amountWanted3;
					if (currentMoney>=totalCost && item3>=amountWanted3){
						item3=item3-amountWanted3;
						switch (amountWanted3){
						//changes grammar
						case 0:
							state=0;
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						default:
							System.out.println("Item" +(amountWanted1 > 1? "s" :"")+ " dispensed, enjoy your bouncy ball" +(amountWanted1 > 1? "s" :"")+ "!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;						
						}
						amountWanted3=0;
					}
					else if (item3>=amountWanted3){
						//makes sure you have enough money
						System.out.println("$" + String.format("%.2f", totalCost)+ " needed.");
						state=0;
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
					}
					else {
						//makes sure there is enough of the product
						System.out.println("Only " + item3 + " left.");
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
						state = 0;
					}
					
					break;
				default:
					System.out.println("invalid");
					state = 1;
					break;
			}				
				break;
			case 3: // Admin state
				System.out.println("Admin mode activated.");
				switch(adminSetting){
				case 1:				
					System.out.println("There are " + item1 + " fidget spinners.");
					System.out.println("How many fidget spinners will you add?");
					Scanner Add1 = new Scanner(System.in);
					try{amountAdded1 = Add1.nextInt();
					}catch(Exception e){
						System.out.println("Invalid");
						adminSetting = 1;
						break;
					}
					if (amountAdded1<0) {
						if (Math.abs(amountAdded1)<=item1){
						item1+=amountAdded1;
						System.out.println(amountAdded1 + " fidget spinners added.");
						System.out.println("There are now " + item1 + " fidget spinners");
						}
						else if (Math.abs(amountAdded1)>=item1){
							System.out.println("Invalid");
							adminSetting = 1;
							break;
						}
					}
					else {
						item1+=amountAdded1;
						System.out.println(amountAdded1 + " fidget spinners added.");
						System.out.println("There are now " + item1 + " fidget spinners");
					}
												
				case 2:
					System.out.println("There are " + item2 + " drones.");
					System.out.println("How many drones will you add?");
					Scanner Add2 = new Scanner(System.in);
									
					try{amountAdded2 = Add2.nextInt();
					}catch(Exception e){
						System.out.println("Invalid");
						adminSetting = 2;
						break;
					}
					if (amountAdded2<0){
						if (Math.abs(amountAdded2)<=item2){
					item2+=amountAdded2;
					System.out.println(amountAdded2 + " drones added.");
					System.out.println("There are now " + item2 + " drones.");
						}
						else if (Math.abs(amountAdded2)>=item2){
							System.out.println("Invalid");
							adminSetting = 2;
							break;
						}
					}
					else {
						item2+=amountAdded2;
						System.out.println(amountAdded2 + " drones added.");
						System.out.println("There are now " + item2 + " drones.");
					}
				case 3:
				System.out.println("There are " + item3 + " bouncy balls.");
				System.out.println("How many bouncy balls will you add?");
				Scanner Add3 = new Scanner(System.in);
				try{amountAdded3 = Add3.nextInt();
				}catch(Exception e){
					System.out.println("Invalid");
					adminSetting = 3;
					break;
				}
				if (amountAdded3<0){
					if (Math.abs(amountAdded3)<=item3){
						item3+=amountAdded3;
						System.out.println(amountAdded3 + " bouncy balls added.");
						System.out.println("There are now " + item3 + " bouncy balls.");
						System.out.println("Admin mode deactivated.");
						state = 0;
						adminSetting = 1;
					}
					else if (Math.abs(amountAdded2)>=item2){
						System.out.println("Invalid");
						adminSetting = 3;
						break;
					}
				}
				else {
					item3+=amountAdded3;
					System.out.println(amountAdded3 + " bouncy balls added.");
					System.out.println("There are now " + item3 + " bouncy balls.");
					System.out.println("Admin mode deactivated.");
					state = 0;
					adminSetting = 1;
				}
				break;
				}
			}
		}		
	}
}	