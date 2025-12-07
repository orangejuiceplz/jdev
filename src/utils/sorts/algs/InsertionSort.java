package utils.sorts.algs;

import static utils.array.ArrayUtils.swap;

public class InsertionSort {

    /**
     *
     * sorts arr via insertionSort
     *
     * @param arr
     * list of ints to sort
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j != 0  && arr[j] < arr[j - 1]) {
                swap( arr, j - 1, j);
                j--;
            }
        }
    }

}
