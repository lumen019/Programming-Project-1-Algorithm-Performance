package sorting;

import java.util.Arrays;

public class PermutationGenerator {

	public static void generateSequence(int n) {
		int[] numbers = new int [n];
		
		for(int i = 0; i < n; i++) {
			numbers[i] = i + 1;
		}
		
		System.out.println(Arrays.toString(numbers));
	}
	
	/**
	 * next permutation 132
	 * 
	 * looking from the right to left
	 * 
	 * 1. find the pivot where Array[i] < Array[i + 1]
	 * 		since 1 < 3, 1 is the pivot
	 * 2. find the successor, from right to left look for the next biggest value of the pivot (1)
	 * 		successor 2
	 * 3. swap the pivot and successor. 132 -> 231 
	 * 4. reverse everything after the pivot (2)
	 * 		231 -> 213
	 * 
	 * 
	 * find pivot
	 * find successor
	 * swap them
	 * reverse everything after pivot
	 * 
	 * @param numbers
	 */
	public static void generatePerms(int[] numbers) {
		int i = numbers.length - 2;  //2nd to last element of array
		
		//finds pivot i 
		while (i >= 0 && numbers[i] >= numbers[i+1]) {
			i--; //loop is only needed if 2nd to last element isn't the pivot
		}
		
		
		if (i >= 0) {
			int j = numbers.length - 1; //last element
			
			//finds successor j 
			while (j >= 0 && numbers[j] <= numbers[i]) {
				j--;
			}
			//method call to swap them
			
			//method call to reverse everything after pivot i
		}

	}
	
	public static void swap (int[] numbers, int i, int j) {
		int placeholder = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = placeholder;
		}
	
	public static void reverse () {
		
	}
	
	public static void main(String[] args) {
		generateSequence(3);

	}

}
