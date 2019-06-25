package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSortTest {
    private static final int[][] testArrays = {
            {1, 3, 5, 7, 9, 3, 6, 8, 0, 2},
            {-5, -3, -2, -6, 4, -14, 32, 11, -16, 6},
            {9, 6, 4, 3, 2, 6, 1, 12, 3, 2},
            {-10, 10, -9, 9, -8, 8, -4, 4, -1, 1},
            {4, 2, -9, 6, -3, 0, 12, 34, 25, 11},
    };

    private static final int[][] defaultArrays = testArrays.clone();

    @Test
    public void mergeSort() {
        MergeSort sort = new MergeSort();
        for (int i = 0; i < 5; i++) {
            sort.mergeSort(testArrays[i]);
            for (int j = 0; j < testArrays[i].length; j++) {
                Map<Integer, Integer> expectedMap = transformToHashMap(i);
                Map<Integer, Integer> actualMap = transformToHashMap(i);
                for (int l = 0; l < testArrays[i].length - 1; l++) {
                    Assert.assertTrue(
                            "Test failed. Array isn't sorted: " + Arrays.toString(testArrays[i]),
                            testArrays[i][l] <= testArrays[i][l + 1]);
                }

                Assert.assertEquals(
                        "Test failed with elements: " + Arrays.toString(testArrays[i]),
                        expectedMap,
                        actualMap);
            }
        }
    }

    private Map<Integer, Integer> transformToHashMap(int index) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number : defaultArrays[index]) {
            if (map.keySet().contains(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }
        return map;
    }
}
