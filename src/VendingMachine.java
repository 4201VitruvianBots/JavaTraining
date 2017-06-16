import java.util.Scanner;

public class VendingMachine {
	public static void main(String[] args) {
		
		int state = 0;
		double currentMoney = 0;
		double itemCost1 = 10;
		double itemCost2 = 100;
		double itemCost3 = 0.50;
		int itemSelection = 0;
		int item1 = 100;
		int item2 = 25;
		int item3 = 1000;
		int amountWanted1 = 0;
		int amountWanted2 = 0;
		int amountWanted3 = 0;
		int amountAdded1 = 0;
		int amountAdded2 = 0;
		int amountAdded3 = 0;
		double totalCost = 0;
		int adminSetting = 1;
		
		while(true){
			switch(state){
			//sets mode
			case 0: // waiting state;
				Scanner moneyInput = new Scanner(System.in);
				//informs user
				System.out.println("Figit Spinners cost $" + String.format("%.2f", (itemCost1)));
				System.out.println("Drones cost $" + String.format("%.2f", (itemCost2)));
				System.out.println("Bouncy balls cost $" + String.format("%.2f", (itemCost3)));
				System.out.println("Input Cash. You need at least $" + String.format("%.2f", (itemCost3 - currentMoney)) + " more.");
				System.out.println("There are " + item1 + " Figit Spinners left.");
				System.out.println("There are " + item2 + " Drones left.");
				System.out.println("There are " + item3 + " bouncy balls left.");
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
				
				if(currentMoney >= itemCost3)
					//takes you to item selection
					state = 1;
				break;
			case 1: //item selection state
				
				Scanner itemInput = new Scanner(System.in);
				System.out.println("Choose an item");
				System.out.println("1 = Figit Spinner");
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
					System.out.println("How many figit spinners do you want?");
					Scanner itemAmount1 = new Scanner(System.in);
					try{amountWanted1 = itemAmount1.nextInt();
					} catch(Exception e){
						System.out.println("Error: Invalid Input");
						//makes it so you can only put numbers in						
					}
					totalCost=itemCost1*amountWanted1; 
					if (currentMoney>=totalCost && item1>=amountWanted1){
				 
					
						item1=item1-amountWanted1;
						amountWanted1=0;
						switch (amountWanted1){
						//changes grammar
						case 0:
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						case 1:
							System.out.println("Item dispensed, enjoy your figit spinner!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
					
							break;
						default:
							System.out.println("Items dispensed, enjoy your figit spinners!");
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
					else if (currentMoney>=totalCost){
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
						amountWanted2=0;
						switch (amountWanted2){
						//changes grammar
						case 0:
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						case 1:
							System.out.println("Item dispensed, enjoy your drone!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
							
						
						default:
							System.out.println("Items dispensed, enjoy your drones!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						}
					}
					else if (item2>=amountWanted2){
						//makes sure you have enough money
						System.out.println("$" + String.format("%.2f", totalCost)+ " needed.");
						state=0;
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
					}
					else if (currentMoney>=totalCost){
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
						amountWanted3=0;
						switch (amountWanted3){
						//changes grammar
						case 0:
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
						case 1:
							System.out.println("Item dispensed, enjoy your bouncy ball!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
							
						
						default:
								System.out.println("Items dispensed, enjoy your bouncy balls!");
							currentMoney=currentMoney-totalCost;
							state=0;	
							System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
							currentMoney=0;
							break;
							}
					}
					else if (item3>=amountWanted3){
						//makes sure you have enough money
						System.out.println("$" + String.format("%.2f", totalCost)+ " needed.");
						state=0;
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
					}
					else if (currentMoney>=totalCost){
						//makes sure there is enough of the product
						System.out.println("Only " + item3 + " left.");
						System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
						currentMoney=0;
						state = 0;
					}
					
					break;
				default:
					System.out.println("invalid");
					System.out.println("$" + String.format("%.2f", currentMoney) + " returned");
					currentMoney=0;
					state = 1;
					break;
			}				
				break;
			case 3: // Admin state
				System.out.println("Admin mode activated.");
				switch(adminSetting){
				case 1:				
				System.out.println("There are " + item1 + " figit spinners.");
				System.out.println("How many figit spinners will you add?");
				Scanner Add1 = new Scanner(System.in);
				try{amountAdded1 = Add1.nextInt();
				}catch(Exception e){
					System.out.println("Invalid");
					adminSetting = 1;
					break;
				}
				item1+=amountAdded1;
				System.out.println(amountAdded1 + " figit spinners added.");
				System.out.println("There are now " + item1 + " figit spinners");
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
				item2+=amountAdded2;
				System.out.println(amountAdded2 + " drones added.");
				System.out.println("There are now " + item2 + " drones.");
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
				item3+=amountAdded3;
				System.out.println(amountAdded3 + " bouncy balls added.");
				System.out.println("There are now " + item3 + " bouncy balls.");
				System.out.println("Admin mode deactivated.");
				state = 0;
				adminSetting = 0;
				break;
				}
			}
		}		
	}
}	