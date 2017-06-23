import java.util.Random;

public class RandomNumbers {
	public static void main(String[] args) {
		// Do not edit these values
		double minValue = -10;
		double maxValue = 10;
		Random r = new Random();
		double randomValue = 0;
		
		double[] sorted = new double[10];
		final int N = 10;
		int count = 0; 
		
		double[] unsortedArray = new double[10];
		
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
			System.out.println(randomValue);
		}
		for(int i = 0 ; i < 9; i++){
			sorted[i]=randomValue;
			for(int j = 0; j < N - 1 - i; j++){
				if(sorted[j] > sorted[j + 1]){
					double temp = sorted[j + 1];
					sorted[j + 1] = sorted[j];
					sorted[j] = temp;
	 			}
			}
		}
		
		
		for(int i = 0; i < 10; i++)
			System.out.print(unsortedArray[i] + "\t");
		System.out.println();
		for(int i = 0; i < 10; i++)
			System.out.print(sorted[i] + "\t");
	}
}
