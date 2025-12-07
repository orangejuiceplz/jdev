package utils.sorts.algs;

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

        System.arraycopy(arr, low, left, 0, lLen);
        System.arraycopy(arr, mid, right, 0, rLen);

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
