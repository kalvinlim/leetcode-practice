import org.junit.Before;
import org.junit.Test;
import stacksAndHeaps.StackAndHeaps;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class StacksAndHeapsTest {
    int[] prices;
    @Before
    public void setup() {
    }

    @Test
    public void stacksAndHeapsTest() {
        prices = new int[]{1, 2, 40, 4, 1, 2};
        assertEquals(43, StackAndHeaps.calculateDiscountedTotal(prices));
    }

    @Test
    public void stacksAndHeapsTest2() {
        prices = new int[]{1, 12, 4, 3, 1, 2, 7, 3, 8};
        assertEquals(29, StackAndHeaps.calculateDiscountedTotal(prices));
    }

    @Test
    public void stacksAndHeapsTest3() {
        prices = new int[]{2, 3, 45, 5, 1, 2};
        assertEquals(50, StackAndHeaps.calculateDiscountedTotal(prices));
    }

    @Test
    public void nextLargerElement() {
        prices = new int[]{1,3,2,4};
        int[] result = StackAndHeaps.nextLargerElement(prices);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new int[]{3, 4, 4, -1}, result);
    }

    @Test
    public void nextLargerElement_singleElement() {
        int[] arr = {5};
        assertArrayEquals(new int[]{-1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_emptyArray() {
        int[] arr = {};
        assertArrayEquals(new int[]{}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_sortedIncreasing() {
        int[] arr = {1, 2, 3, 4, 5};
        // each element's next larger is the next element
        assertArrayEquals(new int[]{2, 3, 4, 5, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_sortedDecreasing() {
        int[] arr = {5, 4, 3, 2, 1};
        // no element has a larger element to its right
        assertArrayEquals(new int[]{-1, -1, -1, -1, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_allEqual() {
        int[] arr = {3, 3, 3, 3};
        // no element is strictly larger
        assertArrayEquals(new int[]{-1, -1, -1, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_allZeros() {
        int[] arr = {0, 0, 0};
        assertArrayEquals(new int[]{-1, -1, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_negativeNumbers() {
        int[] arr = {-5, -2, -3, -1};
        // -5: next larger is -2
        // -2: next larger is -1
        // -3: next larger is -1
        // -1: no larger
        assertArrayEquals(new int[]{-2, -1, -1, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_mixedPositiveNegative() {
        int[] arr = {-1, 0, 1, -2};
        // -1: next larger is 0
        // 0: next larger is 1
        // 1: no larger
        // -2: no larger to right
        assertArrayEquals(new int[]{0, 1, -1, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_largeNumbers() {
        int[] arr = {100, 1000, 500, 2000};
        // 100: next larger is 1000
        // 1000: next larger is 2000
        // 500: next larger is 2000
        // 2000: no larger
        assertArrayEquals(new int[]{1000, 2000, 2000, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_withDuplicates() {
        int[] arr = {1, 2, 1, 2, 3};
        // 1: next larger is 2
        // 2 (first): next larger is 3
        // 1 (second): next larger is 2
        // 2 (second): next larger is 3
        // 3: no larger
        assertArrayEquals(new int[]{2, 3, 2, 3, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_twoElements() {
        int[] arr = {1, 2};
        assertArrayEquals(new int[]{2, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_twoElementsReverse() {
        int[] arr = {2, 1};
        assertArrayEquals(new int[]{-1, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_lastElementLargest() {
        int[] arr = {1, 2, 3, 5, 4};
        // 1: next larger is 2
        // 2: next larger is 3
        // 3: next larger is 5
        // 5: no larger
        // 4: no larger
        assertArrayEquals(new int[]{2, 3, 5, -1, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextLargerElement_largerElementFarAway() {
        int[] arr = {1, 2, 1, 1, 1, 5};
        // 1: next larger is 2
        // 2: next larger is 5
        // 1,1,1: all next larger is 5
        // 5: no larger
        assertArrayEquals(new int[]{2, 5, 5, 5, 5, -1}, StackAndHeaps.nextLargerElement(arr));
    }

    @Test
    public void nextGreaterElement_leetcodeExample() {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        assertArrayEquals(new int[]{-1,3,-1}, new StackAndHeaps().nextGreaterElement(nums1, nums2));
    }

    @Test
    public void nextGreaterElement_subset() {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        assertArrayEquals(new int[]{3, -1}, new StackAndHeaps().nextGreaterElement(nums1, nums2));
    }

    @Test
    public void nextGreaterElement_single() {
        int[] nums1 = {4};
        int[] nums2 = {1,2,3,4};
        assertArrayEquals(new int[]{-1}, new StackAndHeaps().nextGreaterElement(nums1, nums2));
    }

}
