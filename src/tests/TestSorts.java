package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.array.ArrayUtils;
import static utils.sorts.SortUtils.*;
import java.util.Random;

public class TestSorts {

    static Random random;
    static int[] arr;


    @BeforeEach
    void init() {
        random = new Random();
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
    }

    @Test
    void testMerge() {
        arrMergeSort(arr);
        Assertions.assertTrue(ArrayUtils.isSorted(arr));
    }

    @Test
    void testQuick() {
        arrQuickSort(arr);
        Assertions.assertTrue(ArrayUtils.isSorted(arr));
    }
    @Test
    void testSelection() {
        arrSelectionSort(arr);
        Assertions.assertTrue(ArrayUtils.isSorted(arr));
    }

    @Test
    void testInsertion() {
        arrInsertionSort(arr);
        Assertions.assertTrue(ArrayUtils.isSorted(arr));
    }

}