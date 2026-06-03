import backtracking.BackTrackingTemplate;
import org.junit.Before;
import org.junit.Test;

public class BackTrackingTest {

    @Before
    public void setup() {

    }

    @Test
    public void permutations() {
        int[] nums = new int[]{1, 2, 3};

        BackTrackingTemplate.permute(nums);
    }
}
