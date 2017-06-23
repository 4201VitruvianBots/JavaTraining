
public class Main {

	public static void main(String[] args){
		int[] numbers = { 5, 4, -2, 10, 3, 4, 7, 1, 0, -8};
		int[] sorted = new int[10];
		
		for(int i = 0; i < 10; i++)
			sorted[i] = numbers[i];
		
		final int N = 10;
		int count = 0; 
		for(int i = 0 ; i < 9; i++){
			for(int j = 0; j < N - 1 - i; j++){
				if(sorted[j] > sorted[j + 1]){
					int temp = sorted[j + 1];
					sorted[j + 1] = sorted[j];
					sorted[j] = temp;
	 			}
			}
		}
		
		
		for(int i = 0; i < 10; i++)
			System.out.print(numbers[i] + "\t");
		System.out.println();
		for(int i = 0; i < 10; i++)
			System.out.print(sorted[i] + "\t");
		System.out.println("Loop Counts: " + count);
	}

}
