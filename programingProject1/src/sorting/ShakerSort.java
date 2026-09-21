package sorting;

public class ShakerSort {
	
	/**
	 * Sorts the array by comparing neighboring elements
	 * First forward pass moves the largest element to the end. 
	 * Second backwards pass moves the smallest element to the beginning.
	 * Repeats until array is sorted.
	 * 
	 * @param numbers array generated from permutation generator.
	 */
	public static void shakerSort (int[] numbers) {
		int start = 0;
		int end = numbers.length -1;
		boolean swapped = true;
		
		
		//while loop repeats as long as one swap was made (from F to T) during the previous pass.
		while (swapped) {
			swapped = false;
			
			for(int i = start; i< end; i++) {
				if(numbers[i] > numbers[i+1]) {
					
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i+1] = temp;
					swapped = true;
				}
			}
			
			if(!swapped) break;
			swapped = false;
			end--;
			
			for(int i = end - 1; i >= start; i--) {
				if(numbers[i] > numbers [i + 1]) {
					
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i+1] = temp;
					swapped = true;
				}
			}
			start++;
				
		}
	}	
}
		

