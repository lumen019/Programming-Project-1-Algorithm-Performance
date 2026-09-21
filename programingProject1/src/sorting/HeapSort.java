package sorting;

/**
 * HeapSort
 */
public class HeapSort {

  /**
   * Ensures the subtree rooted at index i satisfies the max-heap property:
   * every parent node is >= its children.
   *
   * @param arr the array being heapified
   * @param n   the size of the heap
   * @param i   the index of the root of the subtree to heapify
   */
  public static void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    // if left child exists and is bigger than current largest, update largest
    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }

    // if right child exists and is bigger than current largest, update largest
    if (r < n && arr[r] > arr[largest]) {
      largest = r;
    }

    // if the largest value isn't the root, swap and keep heapifying downward
    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest);
    }
  }

  /**
   * Sorts the array in ascending order using the heap sort algorithm.
   *
   * @param arr the array to sort
   * @param n   the number of elements in the array
   */
  public static void sort(int arr[], int n) {
    // build max-heap.
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    // extract elements from the heap one by one.
    for (int i = n - 1; i >= 0; i--) {
      swap(arr, 0, i);
      heapify(arr, i, 0);
    }
  }

  /**
   * Prints out array in the order it is currently in.
   *
   * @param arr the array to print
   * @param n   number of elements in array
   */
  public static void printArr(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  /**
   * swaps the elements of i and j in the given array.
   *
   * @param arr array to swap indicies from
   * @param i   index 1
   * @param j   index 2
   */
  public static void swap(int arr[], int i, int j) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}
