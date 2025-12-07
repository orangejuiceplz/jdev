package utils.linkedlists;

import types.LinkedList;
import utils.sorts.SortUtils;

import static types.LinkedList.toArray;

public class LinkedListUtils {

    public static void linkedMergeSort(LinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrMergeSort(arr);
        append(list, arr);
    }

    public static void linkedQuickSort(LinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrQuickSort(arr);
        append(list, arr);
    }

    public static void linkedSelectionSort(LinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrSelectionSort(arr);
        append(list, arr);
    }

    public static void linkedInsertionSort(LinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrInsertionSort(arr);
        append(list, arr);
    }

    private static void append(LinkedList list, int[] arr) {
        list.appendBack(arr);
    }



}