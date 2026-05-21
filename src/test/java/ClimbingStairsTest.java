import binarysearch.BinarySearch;
import org.junit.Before;
import org.junit.Test;
import stairs.ClimbingStairs;

import static org.junit.Assert.assertEquals;

public class ClimbingStairsTest {

    @Before
    public void setup() {}

    @Test
    public void test1() {
        int[] cost = new int[]{ 10, 15, 20 };
        int result = ClimbingStairs.minCostClimbingStairs(cost);
        assertEquals(15, result);
    }

    @Test
    public void test2() {
        int[] cost = new int[]{ 1,100,1,1,1,100,1,1,100,1 };
        int result = ClimbingStairs.minCostClimbingStairs(cost);
        assertEquals(6, result);
    }
}
