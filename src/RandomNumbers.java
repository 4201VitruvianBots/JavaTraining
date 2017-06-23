import java.util.Random;

public class RandomNumbers {
	public static void main(String[] args) {
		// Do not edit these values
		double minValue = -10;
		double maxValue = 10;
		Random r = new Random();
		double randomValue = 0;
		
		double[] unsortedArray = new double[10];
		double[] odd = new double[10];
		int oddIndex = 0;
		double[] even = new double[10];
		int evenIndex = 0;
		double[] sorted = new double [10];
		
		

        final int N = 10;
        
		// I haven't gone over for loops yet, but I will next week, just know that this loop is also equivalent to:
		// while(i++ < 10), with int i = 0;
		for(int i = 0; i < 10;){
			// r.nextDouble generates a random double between 0 and 1. 
			// To adjust this to get values from -10 to 10, we first multiply it by the range (20), which equals maxValue - minValue, which changes the range from 0 to 20
			// To adjust it to get the minValue, we just add it, so the range then becomes -10 to 10
			
			// The reason I do this if else is to guarantee an int, otherwise, you'd be refreshing forever until you got an exact integer value
			if(r.nextDouble() < 0.5){ // r.nextInt includes an argument so I can set the upper bound, with the lower bound being 0
				randomValue = minValue + (maxValue - minValue) * r.nextDouble();
				unsortedArray[i] = randomValue;
				
			}
			else{
				randomValue = r.nextInt((int)maxValue - (int)minValue) + minValue; // The min/max is casted here because the .nextInt() function only accepts integer values
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
			}
			else if (Math.abs(randomValue)%2 == 1){
				//checks if this is odd
				System.out.println("This is odd.");
				System.out.println("This is an int");
				oddIndex++;
				odd[oddIndex-1] = randomValue;
			}
			else {
				System.out.println("This is neither even or odd");
				System.out.println("This is a double");
			}
			if (randomValue>0){
				System.out.println("This is positive.");	
				
			}
			else if (randomValue<0){
				System.out.println("This is negative.");
			}
			else {
				System.out.println("This is neither posotive or negative");
			}
			
			
				
			
			System.out.println();
			i++;
		}
	        
        for(int i = 0; i < 10; i++)
            sorted[i] = unsortedArray[i];
        
        for(int l = 0 ; l < 9; l++){
            for(int j = 0; j < N - 1 - l; j++){
                if(sorted[j] > sorted[j + 1]){
                    double temp = sorted[j + 1];
                    sorted[j + 1] = sorted[j];
                    sorted[j] = temp;
                 }
            }
        }
        
        System.out.println( );
        
        for(int m = 0; m < 10; m++){
        	
            System.out.print(unsortedArray[m] + "\t");
            
        }
        
        System.out.println( );
        
        for(int n = 0; n < 10; n++){
            System.out.print(sorted[n] + "\t");	                      
        }
        
        System.out.println();
        System.out.println();
        System.out.println("odd values");
       
        for(int o = 0; o < oddIndex; ){
        	
        	System.out.print(odd[o] + "\t");
        	o++;
        	
        }
        System.out.println();
        System.out.println("even values");
        
        for(int p = 0; p < evenIndex; p++){
        	
        	System.out.print(even[p] + "\t");
        	
        }
        
	}

}
