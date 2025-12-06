package utils;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (high - low < 2) return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid, high);

        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int lLen = mid - low;
        int rLen = high - mid;

        int[] left = new int[lLen];
        int[] right = new int[rLen];

        for (int i = 0; i < lLen; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < rLen; j++) {
            right[j] = arr[mid + j];
        }

        int i = 0, j = 0, k = low;

        while (i < lLen && j < rLen) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < lLen) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < rLen) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}
