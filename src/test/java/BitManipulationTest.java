import org.junit.Before;
import org.junit.Test;
import trees.TreeUtils;

import java.util.*;

public class BitManipulationTest {
    int[] nums;
    @Before
    public void setup() {
    }

    @Test
    public void bits() {
        Integer count = Integer.bitCount(3);
        System.out.println("Bitcount: " + count);
    }

}
