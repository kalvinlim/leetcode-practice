import binning.Knapsack;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackTests {

    @Test
    public void canPartition_basicTrue() {
        int[] nums = {1, 5, 11, 5};
        // 11 = 1 + 5 + 5 => can partition into [11] and [1,5,5]
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_basicFalse() {
        int[] nums = {1, 2, 3, 5};
        // total sum = 11 (odd) => cannot partition equally
        assertFalse(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_singleElementFalse() {
        int[] nums = {1};
        // single element odd sum => cannot partition into two equal subsets
        assertFalse(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_emptyArray_returnsTrue() {
        int[] nums = {};
        // Implementation treats totalSum = 0 => target = 0 and dp[0] = true -> returns true
        // (empty set can be partitioned into two empty subsets of sum 0)
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_allZeros() {
        int[] nums = {0, 0, 0, 0};
        // totalSum = 0 -> trivially partitionable
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_twoEqualNumbers() {
        int[] nums = {2, 2};
        // each subset can be [2] and [2]
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_oddSumCombination() {
        int[] nums = {1, 1, 3};
        // totalSum = 5 -> odd -> cannot partition
        assertFalse(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_duplicatesAndLargeNumbers() {
        int[] nums = {100, 100, 100, 100};
        // sum=400 target=200 -> all four equal numbers, partitionable
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_twoElementsEqual() {
        int[] nums = {5, 5};
        // sum = 10, target = 5 -> both can be 5 each
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_twoElementsNotEqual() {
        int[] nums = {2, 3};
        // sum = 5 (odd) -> cannot partition
        assertFalse(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_largeArrayWithPartition() {
        int[] nums = {2, 2, 1, 1};
        // sum = 6, target = 3 -> can partition as [2,1] and [2,1]
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_largeArrayNoPartition() {
        int[] nums = {1, 2, 5};
        // sum = 8, target = 4 -> cannot form a subset summing to 4
        assertFalse(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_allOnes() {
        int[] nums = {1, 1, 1, 1};
        // sum = 4, target = 2 -> can partition as [1,1] and [1,1]
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_singleLargeNumber() {
        int[] nums = {1000};
        // single number -> cannot partition into two equal subsets
        assertFalse(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_manyZerosWithOne() {
        int[] nums = {0, 0, 0, 1};
        // sum = 1 (odd) -> cannot partition
        assertFalse(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_complexPartition() {
        int[] nums = {1, 5, 11, 5};
        // sum = 22, target = 11 -> [11] and [1,5,5]
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test
    public void canPartition_ninetyNineElemsOfOne() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) nums[i] = 1;
        // sum = 100, target = 50 -> can partition as two subsets of 50 ones each
        assertTrue(Knapsack.canPartition(nums));
    }

    @Test(expected = NullPointerException.class)
    public void canPartition_null_throwsNPE() {
        // Current implementation does not handle null input and will throw NPE.
        Knapsack.canPartition(null);
    }

}
