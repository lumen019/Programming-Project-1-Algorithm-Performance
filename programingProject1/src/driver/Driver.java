package driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import sorting.HeapSort;
import sorting.MergeSort;
import sorting.PermutationGenerator;
//import sorting.QuickSort;
//import sorting.ShakerSort;

/**
 * Runs all four sorting algorithms on every permutation of 0..n-1 and
 * records the comparison counts.
 *
 */
public class Driver {

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

                results.add(new Result("MergeSort", perm.clone(), MergeSort.sort(perm.clone())));
            }

            System.out.println("n = " + n + ": " + results.size() + " results recorded");
            System.out.println(Arrays.toString(computeStats(results, "MergeSort")));
        }
    }

    public static class Result {

        private final String sortName;
        private final int[] permutation;
        private final int comparisons;

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
}