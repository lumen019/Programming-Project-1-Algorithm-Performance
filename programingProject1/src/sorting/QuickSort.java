package sorting;


public class QuickSort{
	
	/**
	 * partition puts everything smaller than the pivot on the left of the
	 * pivot and everything greater than the pivot on the right of the pivot.
	 */
	public static int partition(int[] numbers, int low, int high) {
		
		int pivot = numbers[high]; 
			
		int i = low - 1; 
		
		for(int j = low; j <= high - 1; j++) {
			if(numbers[j] < pivot) {
				i++;
				swap(numbers, i, j);
			}
		}
		
		swap(numbers, i + 1, high);
		return i + 1;
	}
	
	
	/**
	 * recursively calls quickSort to sort left and right side of the pivot until
	 * the base case is met (when there is one number or zero left in that section).
	 * 
	 * @param numbers
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			
			int partitionIndex = partition(numbers, low, high);
			
			quickSort(numbers, low, partitionIndex - 1); //recursively partitions the left side of the pivot
			quickSort(numbers, partitionIndex + 1, high); //recursively partitions the right side of the pivot
		}
	}
		
				
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		int[]numbers = {9, 15, 5, 6, 25, 2, 11};
		int n = numbers.length;
		
		quickSort(numbers, 0, n - 1);
		
		for(int element : numbers) {
			System.out.println(element);
		}
	}

}
