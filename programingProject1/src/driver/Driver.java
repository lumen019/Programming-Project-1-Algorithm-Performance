package driver;

import java.util.ArrayList;
import java.util.List;

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
            PermutationGenerator generator = new PermutationGenerator();

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
                    generator.generatePerms(perm); // moves perm to the next permutation
                }

                // each sort gets its own copy so perm stays unsorted
                results.add(new Result("Mergesort", perm.clone(), Mergesort.sort(perm.clone())));
                results.add(new Result("Quicksort", perm.clone(), Quicksort.sort(perm.clone())));
                results.add(new Result("Shaker sort", perm.clone(), ShakerSort.sort(perm.clone())));
                results.add(new Result("Heapsort", perm.clone(), Heapsort.sort(perm.clone())));
            }

            System.out.println("n = " + n + ": " + results.size() + " results recorded");
        }
    }
}

//TODO adjust code accordingly for input to match