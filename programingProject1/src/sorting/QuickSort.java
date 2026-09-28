package sorting;


public class QuickSort{
	public static void quickSort(int[] numbers, int low, int high) {
		int pivot = numbers[high];
		
		int i = low - 1;
		
		for(int j = low; j <= high - 1; j++) {
			if(numbers[j] < pivot) {
				i++;
				swap(numbers, i, j);
			}
		}
		
		swap(numbers, i + 1, high);
		
		int pivotIndex 
		
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		int[]numbers = {1, 6, 5, 15, 9, 25};
		int n = numbers.length;
		
		quickSort(numbers, 0, n - 1);
		
		for(int element : numbers) {
			System.out.println(element);
		}
	}
}
