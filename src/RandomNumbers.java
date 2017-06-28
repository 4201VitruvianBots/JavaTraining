import java.util.Random;

public class RandomNumbers {
	public static void main(String[] args) {
		// Do not edit these values
		double minValue = -10;
		double maxValue = 10;
		Random r = new Random();
		double randomValue = 0;
		
		double[] unsortedArray = new double[10];
		double[] sortedArray = new double[10];
		double[] evenArray = new double[10];
		int evenIndex = 0;
		double[] oddArray = new double[10];
		int oddIndex = 0;
		double[] positiveArray = new double[10];
		int positiveIndex = 0;
		double[] negativeArray = new double[10];
		int negativeIndex = 0;
		double[] doubleArray = new double[10];
		int doubleIndex = 0;
		int[] intArray = new int[10];
		int intIndex = 0;
		
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
			
			sortedArray[i] = unsortedArray[i];
		}
		
		for(int i = 0 ; i < 10 - 1; i++){
			for(int j = 0; j < 10 - 1 - i; j++){
				if(sortedArray[j] > sortedArray[j + 1]){
					double temp = sortedArray[j + 1];
					sortedArray[j + 1] = sortedArray[j];
					sortedArray[j] = temp;
	 			}
			}
		}

		System.out.println("Unsorted Array:");
		for(int i = 0; i < 10; i++){
			System.out.print(unsortedArray[i] + "\t");
		}
		
		System.out.println("\n\nSorted Array:");
		for(int i = 0; i < 10; i++){
			System.out.print(sortedArray[i] + "\t");
			
			if(sortedArray[i]%2 == 0){
				evenArray[evenIndex] = sortedArray[i];
				evenIndex++;
			}
			if(Math.abs(sortedArray[i]%2) == 1 ){
				oddArray[oddIndex] = sortedArray[i];
				oddIndex++;
			}
			if(sortedArray[i] > 0){
				positiveArray[positiveIndex] = sortedArray[i];
				positiveIndex++;
			}
			if(sortedArray[i] < 0){
				negativeArray[negativeIndex] = sortedArray[i];
				negativeIndex++;
			}
			
			if(Math.abs(sortedArray[i])%2 == 1 || sortedArray[i]%2 == 0){
				intArray[intIndex] = (int) sortedArray[i];
				intIndex++;
			} else {
				doubleArray[doubleIndex] = sortedArray[i];
				doubleIndex++;
			}
			
		}
		
		
		System.out.println("\nEven Numbers:\n");
		for(int i = 0; i < evenIndex; i++)
			System.out.println(evenArray[i]);
		
			
		System.out.println("\nOdd Numbers:\n");
		for(int i = 0; i < oddIndex; i++)
			System.out.println(oddArray[i]);
		
			
		System.out.println("Positive Numbers:\n");
		for(int i = 0; i < positiveIndex; i++)
			System.out.println(positiveArray[i]);
			
				
		System.out.println("Negative Numbers:\n");
		for(int i = 0; i < negativeIndex; i++)
			System.out.println(negativeArray[i]);
		
		
		System.out.println("Integers:\n");
		for(int i = 0; i < intIndex; i++)
			System.out.println(intArray[i]);
		
		
		System.out.println("Doubles(decimals):\n");
		for(int i = 0; i < doubleIndex; i++)
			System.out.println(doubleArray[i]);
		}
	}
			