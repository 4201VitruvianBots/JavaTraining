import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
	public static void main(String[] args) {
		final int N=10;
		// Do not edit these values
		double minValue = -10;
		double maxValue = 10;
		Random r = new Random();
		double randomValue = 0;
		
		double[] unsortedArray = new double[N];
		int[] integerArray = new int[N];
		double[] sortedArray = new double[N];
		
		
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
			System.out.println(i + ": value=" + randomValue);
		}
		System.out.println("SORTED RANDOM ARRAY");
		List<Double> randList = createList(unsortedArray);
		randList.sort(null);
		printList(randList);
		
		// create new array of the random numbers which are integral 
		List<Integer> iList = new ArrayList<Integer>();
		int j=0, intSize=0;
		for(int i=0; i<N; i++) {
			double ai = unsortedArray[i];
			if( ai == (int)ai ) {
				integerArray[j++] = (int)ai;
				intSize=j;
				iList.add((int)ai);
			}
		}	
		System.out.println("SORT ARRAY OF " + intSize + " INTEGERS");		
		iList.sort(null);
		printIntList(iList);
		
		ArrayList<Integer>  negativeList = new ArrayList<Integer>();
		ArrayList<Integer>  positiveList = new ArrayList<Integer>();
		ArrayList<Integer>  evenList = new ArrayList<Integer>();
		ArrayList<Integer>  oddList = new ArrayList<Integer>();

		for(int i=0; i<iList.size(); i++) {
			int n = iList.get(i);
			if( n < 0 ) 
				negativeList.add(n);
			else positiveList.add(n);
			if( n % 2 == 0 ) 
				evenList.add(n);
			else oddList.add(n);
		}
		
		negativeList.sort(null);
		positiveList.sort(null);
		evenList.sort(null);
		oddList.sort(null);
		System.out.println("NEGATIVE INTEGER LIST SIZE=" + negativeList.size());
		printIntList(negativeList);
		System.out.println("POSITIVE INTEGER LIST SIZE=" + positiveList.size());
		printIntList(positiveList);
		System.out.println("EVEN INTEGER LIST SIZE=" + evenList.size());
		printIntList(evenList);
		System.out.println("ODD INTEGER LIST SIZE=" + oddList.size());
		printIntList(oddList);

	}
	
	private static List<Integer> createList(int[] ints) {
		List<Integer> outList = new ArrayList<Integer>();
		for (int index = 0; index < ints.length; index++)
		{
		    outList.add(ints[index]);
		}
		return outList;
	}
	private static List<Double> createList(double[] array) {
		List<Double> outList = new ArrayList<Double>();
		for (int index = 0; index < array.length; index++)
		{
		    outList.add(array[index]);
		}
		return outList;
	}
	private static void printIntList(List<Integer> list) {
		for( int i=0; i < list.size(); i++ ) {
			System.out.println(list.get(i));
		}
	}
	private static void printList(List<Double> list) {
		for( int i=0; i < list.size(); i++ ) {
			System.out.println(list.get(i));
		}
	}
}
