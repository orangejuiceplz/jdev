package utils.linkedlists;

import types.SinglyLinkedList;
import utils.sorts.SortUtils;

import static types.SinglyLinkedList.toArray;

public class LinkedListUtils {

    public static void linkedMergeSort(SinglyLinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrMergeSort(arr);
        append(list, arr);
    }

    public static void linkedQuickSort(SinglyLinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrQuickSort(arr);
        append(list, arr);
    }

    public static void linkedSelectionSort(SinglyLinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrSelectionSort(arr);
        append(list, arr);
    }

    public static void linkedInsertionSort(SinglyLinkedList list) {
        int[] arr = toArray(list);
        SortUtils.arrInsertionSort(arr);
        append(list, arr);
    }

    private static void append(SinglyLinkedList list, int[] arr) {
        list.appendBack(arr);
    }



}