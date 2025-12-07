package utils.sorts.algs;

import static utils.array.ArrayUtils.swap;

public class SelectionSort {

    /**
     *
     * sorts arr via selection sort
     *
     * @param arr
     * array of ints to be sorted
     *
     */

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int best = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[best]) {
                    best = j;
                }
            }

            if (best != i) {
                swap(arr, best, i);
            }
        }
    }

}
