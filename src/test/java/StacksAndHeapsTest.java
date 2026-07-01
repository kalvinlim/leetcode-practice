import org.junit.Before;
import org.junit.Test;
import stacksAndHeaps.StackAndHeaps;

import static org.junit.Assert.assertEquals;

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

}
