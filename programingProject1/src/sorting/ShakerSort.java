package sorting;

public class ShakerSort {
	
	public static void shakerSort (int[] numbers) {
		int start = 0;
		int end = numbers.length -1;
		boolean swapped = true;
		
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
		

