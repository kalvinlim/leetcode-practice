import backtracking.BackTrackingTemplate;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BackTrackingTest {

    @Before
    public void setup() {

    }

    @Test
    public void permutations() {
        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> result = BackTrackingTemplate.permute(nums);
        System.out.println("FINAL NUMS = " + result);

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(1, 3, 2),
            Arrays.asList(2, 1, 3),
            Arrays.asList(2, 3, 1),
            Arrays.asList(3, 1, 2),
            Arrays.asList(3, 2, 1)
        );

        assertEquals(expected, result);
    }
}
