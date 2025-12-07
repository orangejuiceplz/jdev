package utils.sorts.algs;

import static utils.array.ArrayUtils.swap;

public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (high - low < 2) return;

        int pivotIndex = LPartition(arr, low, high);

        quickSort(arr, low, pivotIndex);
        quickSort(arr, pivotIndex + 1, high);

    }

    private static int LPartition(int[] arr, int low, int high) {
        int pivot = arr[high - 1];

        int i = low - 1;

        for (int j = low; j < high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high - 1);
        return i + 1;
    }


}
