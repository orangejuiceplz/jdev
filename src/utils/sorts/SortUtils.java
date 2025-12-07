package utils.sorts;

import utils.sorts.algs.InsertionSort;
import utils.sorts.algs.MergeSort;
import utils.sorts.algs.QuickSort;
import utils.sorts.algs.SelectionSort;

public class SortUtils {
    public static void arrMergeSort(int[] arr) {
        MergeSort.mergeSort(arr);
    }

    public static void arrQuickSort(int[] arr) {
        QuickSort.quickSort(arr);
    }

    public static void arrSelectionSort(int[] arr) {
        SelectionSort.selectionSort(arr);
    }

    public static void arrInsertionSort(int[] arr) {
        InsertionSort.insertionSort(arr);
    }
}
