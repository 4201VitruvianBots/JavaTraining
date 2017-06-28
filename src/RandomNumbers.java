import java.util.Random;

public class RandomNumbers {
	public static void main(String[] args) {
		// Do not edit these values
		double minValue = -10;
		double maxValue = 10;
		Random r = new Random();
		double randomValue = 0;
		
		double[] unsortedArray = new double[10];
		
		
		double[] evenArray = new double[10];
		int even = 0;
		
		double[] oddArray = new double[10];
		int odd= 0;
		
		double[] posArray = new double[10];
		int pos = 0;
		
		double[] negArray = new double[10];
		int neg = 0;
		
		double[] intArray = new double[10];
		int x = 0;
		
		double[] doubleArray = new double[10];
		int dob = 0;
		
		
		// I haven't gone over for loops yet, but I will next week, just know that this loop is also equivalent to:
		// while(i++ < 10), with int i = 0;
		
		for(int i = 0; i < 10; i++){
			// r.nextDouble generates a random double between 0 and 1. 
			// To adjust this to get values from -10 to 10, we first multiply it by the range (20), which equals maxValue - minValue, which changes the range from 0 to 20
			// To adjust it to get the minValue, we just add it, so the range then becomes -10 to 10
			
			// The reason I do this if else is to guarantee an int, otherwise, you'd be refreshing forever until you got an exact integer value
			if(r.nextInt(3) > 1){ // r.nextInt includes an argument so I can set the upper bound, with the lower bound being 0
				randomValue = minValue + (maxValue - minValue) * r.nextDouble();
				unsortedArray[i] = randomValue;
			}
			else{
				randomValue = r.nextInt((int)maxValue - (int)minValue) + minValue; // The min/max is casted here because the .nextInt() function only accepts integer values
				unsortedArray[i] = randomValue;
			}
			// Example output format. The number [x] is an (odd/even?) (double/int?) that is (positive/negative?)
			//System.out.println(randomValue);
			
			if(randomValue % 2 == 0){
				evenArray[i] = randomValue;
			}
			else{
				oddArray[i] = randomValue;
			}
			
			if(randomValue <0 ){
				negArray[i] = randomValue;
			}
			else{
				posArray[i] = randomValue;
			}
			System.out.println("The odd values are: " + oddArray);
			System.out.println("The even values are: " + evenArray);
		}
	}
}
