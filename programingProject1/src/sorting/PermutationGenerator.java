package sorting;

import java.util.Arrays;

public class PermutationGenerator {

	public static void generatePerms(int n) {
		int[] numbers = new int [n];
		
		for(int i = 0; i < n; i++) {
			numbers[i] =i;
		}
		
		System.out.println(Arrays.toString(numbers));
	}
	
	
	public static void main(String[] args) {
		generatePerms(3);

	}

}
