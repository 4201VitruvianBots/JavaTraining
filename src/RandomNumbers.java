import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
	public static void main(String[] args) {
		// Do not edit these values
		double minValue = -10;
		double maxValue = 10;
		
		Random r = new Random();
		
		double randomValue = 0;
		
		int count = 0;
		
		int inputCount = 0;
		
		
		final int N = 10; //Number's sorted (Keep it small please.)
		
		
		
		double[] odd = new double[N];
		int oddIndex = 0;
		
		double[] even = new double[N];
		int evenIndex = 0;
		
		double[] positive = new double[N];
		int positiveIndex = 0;
		
		double[] negative = new double [N];
		int negativeIndex = 0;
		
		double[] ints = new double[N];
		int intIndex = 0;
		
		double[] doubles = new double[N];
		int doubleIndex = 0;
		
		
		
		double[] unsortedArray = new double[N];
		double[] sorted = new double[N];
		
		

        
		// I haven't gone over for loops yet, but I will next week, just know that this loop is also equivalent to:
		// while(i++ < 10), with int i = 0;
		for(int i = 0; i < N;){
			// r.nextDouble generates a random double between 0 and 1. 
			// To adjust this to get values from -10 to 10, we first multiply it by the range (20), which equals maxValue - minValue, which changes the range from 0 to 20
			// To adjust it to get the minValue, we just add it, so the range then becomes -10 to 10
			
			// The reason I do this if else is to guarantee an int, otherwise, you'd be refreshing forever until you got an exact integer value
			if(r.nextDouble() < 0.4){ // r.nextInt includes an argument so I can set the upper bound, with the lower bound being 0
				randomValue = minValue + (maxValue - minValue) * r.nextDouble();
				unsortedArray[i] = randomValue;
				
			}
			else if(r.nextDouble()<=0.0){
				System.out.println("Input number");
				Scanner randomValueInput = new Scanner(System.in);
				String randomValueString = randomValueInput.next();				
				try{
				randomValue = (Double.valueOf(randomValueString));
				inputCount++;
				} catch(Exception e){
					System.out.println("Error");
				}
			}
			
			else{
				randomValue = r.nextInt((int)maxValue - (int)minValue + 1) + minValue; // The min/max is casted here because the .nextInt() function only accepts integer values
				unsortedArray[i] = randomValue;
				
			}
			// Example output format. The number [x] is an (odd/even?) (double/int?) that is (positive/negative?)
			//System.out.println(randomValue);
			System.out.println(randomValue);
			if ((randomValue)%2 == 0){
				//checks if it is even
				System.out.println("This is even.");
				System.out.println("This is an int");
				evenIndex++;
				even[evenIndex-1] = randomValue;
				intIndex++;
				ints[intIndex-1] = randomValue;
			}
			else if (Math.abs(randomValue)%2 == 1){
				//checks if this is odd
				System.out.println("This is odd.");
				System.out.println("This is an int");
				oddIndex++;
				odd[oddIndex-1] = randomValue;
				intIndex++;
				ints[intIndex-1] = randomValue;
			}
			else {
				System.out.println("This is neither even or odd");
				System.out.println("This is a double");
				//checks if this is a double
				doubleIndex++;
				doubles[doubleIndex-1] = randomValue;
				}
			if (randomValue>0){
				System.out.println("This is positive.");
				//checks if this is positive
				positiveIndex++;
				positive[positiveIndex-1] = randomValue;
				
			}
			else if (randomValue<0){
				//checks if this is negative
				System.out.println("This is negative.");
				negativeIndex++;
				negative[negativeIndex-1] = randomValue;
			}
			else {
				//checks if this is zero
				System.out.println("This is neither positive or negative");
			}
			
			
				
			
			System.out.println();
			i++;
		}
	        
        for(int i = 0; i < N; i++)
            sorted[i] = unsortedArray[i];
        //gets ready to sort
        
        for(int i = 0 ; i < N-1; i++){ //sorting
            for(int j = 0; j < N - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
                count++;
            }
        }
        
        System.out.println( );
        
        for(int i = 0; i < N; i++){
        	
            System.out.print(unsortedArray[i] + "\t"); //displays unsorted array
            
        }
        
        System.out.println( );
        
        for(int i = 0; i < N; i++){
            System.out.print(sorted[i] + "\t");	            //displays sorted array           
        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("odd values: " + oddIndex);
       
        for(int i = 0; i < oddIndex; ){
        	
        	System.out.print(odd[i] + "\t"); // displays odd values
        	i++;
        	
        }
        for(int i = 0; i < oddIndex; i++)
            sorted[i] = odd[i]; //gets ready to sort odd values
        
        for(int i = 0 ; i < oddIndex; i++){ //sorts odd values
            for(int j = 0; j < oddIndex - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        System.out.println();
        for(int i = 0; i < oddIndex; ){
        	
        	System.out.print(sorted[i] + "\t"); //displays sorted odd values
        	i++;
        	
        }
        System.out.println();
        System.out.println();
        System.out.println("even values: " + evenIndex);
        
        for(int i = 0; i < evenIndex; i++){
        	
        	System.out.print(even[i] + "\t"); //displays even value
        	
        }
        for(int i = 0; i < evenIndex; i++)
            sorted[i] = even[i]; // gets ready to sort even values
        
        for(int i = 0 ; i < evenIndex; i++){ // sorts even values
            for(int j = 0; j < evenIndex - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        System.out.println();
        for(int i = 0; i < evenIndex; ){
        	
        	System.out.print(sorted[i] + "\t"); //displays sorted even values
        	i++;
        	
        }
        System.out.println();
        System.out.println();
        System.out.println("neither odd or even: " + doubleIndex);
        
        for(int i = 0; i < doubleIndex; i++){
        	
        	System.out.print(doubles[i] + "\t"); //displays doubles
        	
        }
        for(int i = 0; i < doubleIndex; i++)
            sorted[i] = doubles[i]; //gets ready to sort doubles
        
        for(int i = 0 ; i < doubleIndex; i++){//sorts doubles
            for(int j = 0; j < doubleIndex - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        System.out.println();
        for(int i = 0; i < doubleIndex; ){
        	
        	System.out.print(sorted[i] + "\t"); //displays sorted doubles
        	i++;
        	
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("positive values: " + positiveIndex);
        
        for(int i = 0; i < positiveIndex; i++){
        	
        	System.out.print(positive[i] + "\t"); //displays positive values
        	
        }
        for(int i = 0; i < positiveIndex; i++)
            sorted[i] = positive[i]; //gets ready to sort positive values
        
        for(int i = 0 ; i < positiveIndex; i++){ //sorts positive values
            for(int j = 0; j < positiveIndex - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        System.out.println();
        for(int i = 0; i < positiveIndex; ){
        	
        	System.out.print(sorted[i] + "\t"); //displays sorted positive values
        	i++;
        	
        }
        System.out.println();
        System.out.println();
        System.out.println("negative values: " + negativeIndex);
        
        for(int i = 0; i < negativeIndex; i++){
        	
        	System.out.print(negative[i] + "\t"); //displays negative values
        	
        }
        for(int i = 0; i < negativeIndex; i++)
            sorted[i] = negative[i]; //gets ready to sort negative values
        
        for(int i = 0 ; i < negativeIndex; i++){ //sorts negative values
            for(int j = 0; j < negativeIndex - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        System.out.println();
        for(int i = 0; i < negativeIndex; ){
        	
        	System.out.print(sorted[i] + "\t"); //displays sorted negative valuse
        	i++;
        	
        }
        System.out.println();
        System.out.println();
        System.out.println("zeros: " + (N-positiveIndex-negativeIndex));
        for (int i = 0; i < N - positiveIndex - negativeIndex; i++){
        	System.out.println("0.00"); //counts zeros
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("ints: " + intIndex);
        
        for(int i = 0; i < intIndex; i++){
        	
        	System.out.print(ints[i] + "\t"); //displays ints
        	
        }
        for(int i = 0; i < intIndex; i++)
            sorted[i] = ints[i]; //gets ready to sort ints
        
        for(int i = 0 ; i < intIndex; i++){ //sorts ints
            for(int j = 0; j < intIndex - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        System.out.println();
        for(int i = 0; i < intIndex; ){
        	
        	System.out.print(sorted[i] + "\t"); //displays sorted ints
        	i++;
        	
        }
        System.out.println();
        System.out.println();
        System.out.println("doubles: " + doubleIndex);
        
        for(int i = 0; i < doubleIndex; i++){
        	
        	System.out.print(doubles[i] + "\t"); //displays doubles
        	
        }
        for(int i = 0; i < doubleIndex; i++)
            sorted[i] = doubles[i]; //gets ready to sort doubles
        
        for(int i = 0 ; i < doubleIndex; i++){ //sort doubles
            for(int j = 0; j < doubleIndex - 1 - i; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        System.out.println();
        for(int i = 0; i < doubleIndex; ){
        	
        	System.out.print(sorted[i] + "\t"); //displays sorted doubles
        	i++;
        	
        }
        System.out.println();
        System.out.println();
        System.out.println("Number of times sorted: " + count);
        System.out.println("Input count: " + inputCount);
       }
}