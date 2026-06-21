import org.junit.Before;
import org.junit.Test;
import pointers.Sums;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SumsTest {

    @Before
    public void setup() {
    }

    // ============ twoSum Tests ============

    @Test
    public void twoSum_basicCase() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = Sums.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void twoSum_targetAtEndOfArray() {
        int[] nums = {1, 2, 3, 8, 9};
        int target = 17;
        int[] result = Sums.twoSum(nums, target);
        assertArrayEquals(new int[]{3, 4}, result);
    }

    @Test
    public void twoSum_targetInMiddle() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = Sums.twoSum(nums, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void twoSum_withNegativeNumbers() {
        int[] nums = {-1, -2, -3, 5, 10};
        int target = 7;
        int[] result = Sums.twoSum(nums, target);
        assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    public void twoSum_withZero() {
        int[] nums = {0, 1, 2, 3};
        int target = 0;
        int[] result = Sums.twoSum(nums, target);
        // Should handle zero in the array
        assertTrue(result.length == 2 || result.length == 0);
    }

    @Test
    public void twoSum_duplicateValues() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int target = 2;
        int[] result = Sums.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void twoSum_largeNumbers() {
        int[] nums = {1000000, 999, 500000, 1};
        int target = 1000001;
        int[] result = Sums.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 3}, result);
    }

    @Test
    public void twoSum_allNegativeNumbers() {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        int target = -4;
        int[] result = Sums.twoSum(nums, target);
        // -4 + 0 = -4 at indices 0 and 3
        assertArrayEquals(new int[]{0, 3}, result);
    }

    @Test
    public void twoSum_smallArray() {
        int[] nums = {5, 5};
        int target = 10;
        int[] result = Sums.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    // ============ twoSumSorted Tests (LeetCode 167) ============

    @Test
    public void twoSumSorted_basicCase() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = Sums.twoSumSorted(numbers, target);
        // Returns 1-indexed: indices 1 and 2 (0-indexed would be 0 and 1)
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void twoSumSorted_targetsAtEnd() {
        int[] numbers = {1, 2, 3, 8, 9};
        int target = 17;
        int[] result = Sums.twoSumSorted(numbers, target);
        // 8 + 9 = 17, at indices 3 and 4 (0-indexed), so 4 and 5 (1-indexed)
        assertArrayEquals(new int[]{4, 5}, result);
    }

    @Test
    public void twoSumSorted_targetsAtStart() {
        int[] numbers = {1, 2, 7, 11, 15};
        int target = 3;
        int[] result = Sums.twoSumSorted(numbers, target);
        // 1 + 2 = 3, at indices 0 and 1 (0-indexed), so 1 and 2 (1-indexed)
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void twoSumSorted_targetsInMiddle() {
        int[] numbers = {1, 3, 4, 5, 7, 11};
        int target = 9;
        int[] result = Sums.twoSumSorted(numbers, target);
        // 4 + 5 = 9, at indices 2 and 3 (0-indexed), so 3 and 4 (1-indexed)
        assertArrayEquals(new int[]{3, 4}, result);
    }

    @Test
    public void twoSumSorted_withNegativeNumbers() {
        int[] numbers = {-10, -5, -2, 0, 3, 7, 10};
        int target = 5;
        int[] result = Sums.twoSumSorted(numbers, target);
        // -5 + 10 = 5, at indices 1 and 6 (0-indexed), so 2 and 7 (1-indexed)
        assertArrayEquals(new int[]{2, 7}, result);
    }

    @Test
    public void twoSumSorted_allNegatives() {
        int[] numbers = {-8, -5, -3, -1};
        int target = -9;
        int[] result = Sums.twoSumSorted(numbers, target);
        // -8 + (-1) = -9, at indices 0 and 3 (0-indexed), so 1 and 4 (1-indexed)
        assertArrayEquals(new int[]{1, 4}, result);
    }

    @Test
    public void twoSumSorted_withZero() {
        int[] numbers = {-5, -1, 0, 2, 5, 8};
        int target = 0;
        int[] result = Sums.twoSumSorted(numbers, target);
        // -5 + 5 = 0, at indices 0 and 4 (0-indexed), so 1 and 5 (1-indexed)
        assertArrayEquals(new int[]{1, 5}, result);
    }

    @Test
    public void twoSumSorted_smallArray() {
        int[] numbers = {0, 0};
        int target = 0;
        int[] result = Sums.twoSumSorted(numbers, target);
        // 0 + 0 = 0, at indices 0 and 1 (0-indexed), so 1 and 2 (1-indexed)
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void twoSumSorted_largeNumbers() {
        int[] numbers = {1, 100, 500, 1000, 2000};
        int target = 1100;
        int[] result = Sums.twoSumSorted(numbers, target);
        // 100 + 1000 = 1100, at indices 1 and 3 (0-indexed), so 2 and 4 (1-indexed)
        assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    public void twoSumSorted_duplicateValues() {
        int[] numbers = {1, 2, 2, 2, 3, 4, 5};
        int target = 4;
        int[] result = Sums.twoSumSorted(numbers, target);
        // 1 + 3 = 4, at indices 0 and 4 (0-indexed), so 1 and 5 (1-indexed)
        assertArrayEquals(new int[]{1, 5}, result);
    }

    @Test
    public void twoSumSorted_oppositeNumbers() {
        int[] numbers = {-100, -50, -1, 1, 50, 100};
        int target = 0;
        int[] result = Sums.twoSumSorted(numbers, target);
        // -100 + 100 = 0, at indices 0 and 5 (0-indexed), so 1 and 6 (1-indexed)
        assertArrayEquals(new int[]{1, 6}, result);
    }

    // ============ threeSum Tests ============

    @Test
    public void threeSum_basicCase() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Expected: [[-1, -1, 2], [-1, 0, 1]]
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(-1, -1, 2)));
        assertTrue(result.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    public void threeSum_allZeros() {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Only one triplet: [0, 0, 0]
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList(0, 0, 0)));
    }

    @Test
    public void threeSum_allPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> result = Sums.threeSum(nums);
        // No triplet sums to 0
        assertEquals(0, result.size());
    }

    @Test
    public void threeSum_allNegative() {
        int[] nums = {-5, -4, -3, -2, -1};
        List<List<Integer>> result = Sums.threeSum(nums);
        // No triplet sums to 0
        assertEquals(0, result.size());
    }

    @Test
    public void threeSum_mixedWithDuplicates() {
        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Expected: [[-2, 0, 2], [-2, 1, 1]]
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(-2, 0, 2)));
        assertTrue(result.contains(Arrays.asList(-2, 1, 1)));
    }

    @Test
    public void threeSum_multipleTriplets() {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Should have multiple valid triplets
        assertFalse(result.isEmpty());
        // Verify no duplicates in result
        assertEquals(result.size(), result.stream().distinct().count());
    }

    @Test
    public void threeSum_singleSolution() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> result = Sums.threeSum(nums);
        assertEquals(1, result.size());
        assertTrue(result.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    public void threeSum_largeDuplicates() {
        int[] nums = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Two unique triplets: [-1, 0, 1] and [0, 0, 0]
        assertEquals("Should find 2 unique triplets", 2, result.size());
        assertTrue("Should contain [-1, 0, 1]", result.contains(Arrays.asList(-1, 0, 1)));
        assertTrue("Should contain [0, 0, 0]", result.contains(Arrays.asList(0, 0, 0)));
    }

    @Test
    public void threeSum_noValidTriplets() {
        int[] nums = {-1000, -999, -998, 1, 2, 3};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Very unlikely to have valid triplets here
        assertTrue(result.isEmpty());
    }

    @Test
    public void threeSum_symmetricAroundZero() {
        int[] nums = {-3, -1, 0, 1, 3};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Expected: [-3, 0, 3], [-1, 0, 1]
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(-3, 0, 3)));
        assertTrue(result.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    public void threeSum_withManyDuplicateNegatives() {
        int[] nums = {-2, -2, -2, 1, 1, 1};
        List<List<Integer>> result = Sums.threeSum(nums);
        // One valid triplet: [-2, 1, 1] sums to 0
        assertEquals("Should find 1 triplet", 1, result.size());
        assertTrue("Should contain [-2, 1, 1]", result.contains(Arrays.asList(-2, 1, 1)));
    }

    @Test
    public void threeSum_emptyAfterSorting() {
        int[] nums = {0};
        List<List<Integer>> result = Sums.threeSum(nums);
        // Can't form triplet with single element
        assertEquals(0, result.size());
    }

}
