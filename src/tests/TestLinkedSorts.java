package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.SinglyLinkedList;

import utils.array.ArrayUtils;

import java.util.Random;

import static types.SinglyLinkedList.toArray;
import static utils.linkedlists.LinkedListUtils.*;

public class TestLinkedSorts {

    SinglyLinkedList list;
    Random random;

    @BeforeEach
    void init() {
        random = new Random();
        list = new SinglyLinkedList();
        for (int i = 0; i < 1000; i++) {
            list.append(random.nextInt(100000));
        }
    }

    // ARRAY SORTING (NO CHANGING POINTERS)

    @Test
    void testMergeSort() {
        linkedMergeSort(list);
        Assertions.assertTrue(ArrayUtils.isSorted(toArray(list)), "The LinkedList was not sorted!");
    }

    @Test
    void testQuickSort() {
        linkedQuickSort(list);
        Assertions.assertTrue(ArrayUtils.isSorted(toArray(list)), "The LinkedList was not sorted!");
    }

    @Test
    void testSelectionSort() {
        linkedSelectionSort(list);
        Assertions.assertTrue(ArrayUtils.isSorted(toArray(list)), "The LinkedList was not sorted!");
    }

    @Test
    void testInsertionSort() {
        linkedInsertionSort(list);
        Assertions.assertTrue(ArrayUtils.isSorted(toArray(list)), "The LinkedList was not sorted!");
    }

}