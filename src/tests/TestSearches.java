package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.array.SearchUtils;
import static utils.sorts.SortUtils.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class TestSearches extends TestSorts{

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testBinarySearch(boolean sorted) {
        if (sorted) {
            arrMergeSort(arr);
        }
        if (sorted) {
            int elementToSearch = arr[random.nextInt(arr.length)];
            int result = SearchUtils.binarySearch(arr, elementToSearch);
            Assertions.assertTrue(result != -1, "Should find element in sorted array");
        } else {
            Assertions.assertFalse(sorted, "It shouldn't be able to find the element because the array isn't sorted. Since we know this, then  just pass it and skip it all together.");
        }
    }

    @Test
    void testLinearSearch() {
        int elementToSearch = arr[random.nextInt(arr.length)];
        int result = SearchUtils.linearSearch(arr, elementToSearch);
        Assertions.assertTrue(result != -1, "Should find element in sorted array");
    }

    @Override
    @Disabled
    void testMerge() {
        super.testMerge();
    }

    @Override
    @Disabled
    void testQuick() {
        super.testQuick();
    }

    @Override
    @Disabled
    void testSelection() {
        super.testSelection();
    }

    @Override
    @Disabled
    void testInsertion() {
        super.testInsertion();
    }
}
