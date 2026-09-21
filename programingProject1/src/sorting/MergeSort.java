package sorting;

import java.util.Arrays;

public class MergeSort {
	
	private static int comparisons;
	
	public static int sort(int[] a) {
		comparisons = 0;
		mergeSort(a);
		return comparisons;
	}
	
	public static void mergeSort(int[] arr) {
		if(arr.length <= 1) {
			return;
		}
		
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
	}
	
	private static void merge(int[] left, int[] right, int[] arr) {
		int i = 0; //pos in left
		int j = 0; //pos in right
		int k = 0; //pos in arr (where the next value goes)
		
		while (i < left.length && j < right.length) {
			comparisons++;
			if (left[i] <= right[i]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			
			k++;
		}
		
		while(j < left.length) {
			arr[k] = right[j];
			j++;
			k++;
		}
		
		while(j < right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

}
