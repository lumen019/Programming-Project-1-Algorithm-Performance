package driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import sorting.HeapSort;
import sorting.MergeSort;
import sorting.PermutationGenerator;
import sorting.QuickSort;
import sorting.ShakerSort;

/**
 * Runs all four sorting algorithms on every permutation of 0..n-1 and
 * records the comparison counts.
 *
 */
public class Driver {
	
	private static final boolean SHOW_EXTREMES = false;
	
    /**
     * Runs the experiment for n = 4, 6, and 8.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        int[] sizes = { 4, 6, 8 };

        for (int n : sizes) {
            List<Result> results = new ArrayList<>();

            int total = 1; // n factorial
            for (int i = 2; i <= n; i++) {
                total *= i;
            }

            int[] perm = new int[n];
            for (int i = 0; i < n; i++) {
                perm[i] = i;
            }

            for (int k = 0; k < total; k++) {
                if (k > 0) {
                    PermutationGenerator.generatePerms(perm);
                }

                int[] mergeCopy = perm.clone();
                int mergeComparisons = MergeSort.sort(mergeCopy);
                if (!isSorted(mergeCopy)) {
                    throw new IllegalStateException("MergeSort failed on " + Arrays.toString(perm));
                }
                results.add(new Result("MergeSort", perm.clone(), mergeComparisons));

                int[] heapCopy = perm.clone();
                int heapComparisons = HeapSort.sort(heapCopy);
                if (!isSorted(heapCopy)) {
                    throw new IllegalStateException("HeapSort failed on " + Arrays.toString(perm));
                }
                results.add(new Result("HeapSort", perm.clone(), heapComparisons));
                
                int[] quickCopy = perm.clone();
                int quickComparisons = QuickSort.sort(quickCopy);
                if (!isSorted(quickCopy)) {
                    throw new IllegalStateException("QuickSort failed on " + Arrays.toString(perm));
                }
                results.add(new Result("QuickSort", perm.clone(), quickComparisons));

                int[] shakerCopy = perm.clone();
                int shakerComparisons = ShakerSort.sort(shakerCopy);
                if (!isSorted(shakerCopy)) {
                    throw new IllegalStateException("ShakerSort failed on " + Arrays.toString(perm));
                }
                results.add(new Result("ShakerSort", perm.clone(), shakerComparisons));
            }
            
            System.out.println("n = " + n + ":");
            printStats(results, "MergeSort");
            printStats(results, "HeapSort");
            printStats(results, "QuickSort");
            printStats(results, "ShakerSort");
            
            if (SHOW_EXTREMES) {
                printExtremes(results, "MergeSort", 10);
                printExtremes(results, "HeapSort", 10);
                printExtremes(results, "QuickSort", 10);
                printExtremes(results, "ShakerSort", 10);

            }
            
            System.out.println();        
         }
    }
   /**
    * Represents the outcome of running one sorting algorithm on one permutation,
	* holding the algorithm's name, the permutation, and the number of comparisons
	* made by the algorithm.
	* 
	*/
	
    public static class Result {

        private final String sortName;
        private final int[] permutation;
        private final int comparisons;
        
	    /**
        * Constructs a Result recording the outcome of one sort on one permutation.
		*
		* @param sortName the name of the algorithm, e.g. MergeSort
		* @param permutation the permutation used by the algorithm before the sorting process begins
		* @param
	    */

        public Result(String sortName, int[] permutation, int comparisons) {
            this.sortName = sortName;
            this.permutation = permutation;
            this.comparisons = comparisons;
        }

        public String getSortName() {
            return sortName;
        }

        public int[] getPermutation() {
            return permutation;
        }

        public int getComparisons() {
            return comparisons;
        }
    }

    private static long[] computeStats(List<Result> results, String sortName) {
        long count = 0;
        long total = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Result r : results) {
            if (r.getSortName().equals(sortName)) {
                int c = r.getComparisons();
                count++;
                total += c;
                if (c < min) min = c;
                if (c > max) max = c;
            }
        }

        return new long[] { count, total, min, max };
    }
    
    private static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }
    
    private static void printStats(List<Result> results, String sortName) {
        long[] stats = computeStats(results, sortName);
        long count = stats[0];
        long total = stats[1];
        long min = stats[2];
        long max = stats[3];
        double average = total / (double) count;

        System.out.printf("%-10s count=%d  total=%d  min=%d  max=%d  avg=%.2f%n",
                sortName, count, total, min, max, average);
    }
    
    private static void printExtremes(List<Result> results, String sortName, int count) {
        List<Result> filtered = new ArrayList<>();
        for (Result r : results) {
            if (r.getSortName().equals(sortName)) {
                filtered.add(r);
            }
        }

        filtered.sort(Comparator.comparingInt(Result::getComparisons));

        System.out.println(sortName + " - best " + count + ":");
        for (int i = 0; i < count && i < filtered.size(); i++) {
            Result r = filtered.get(i);
            System.out.println("  " + Arrays.toString(r.getPermutation()) + " -> " + r.getComparisons());
        }

        System.out.println(sortName + " - worst " + count + ":");
        for (int i = 0; i < count && i < filtered.size(); i++) {
            Result r = filtered.get(filtered.size() - 1 - i);
            System.out.println("  " + Arrays.toString(r.getPermutation()) + " -> " + r.getComparisons());
        }
    }
}