import binarysearch.BinarySearch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Before
    public void setup() {

    }

    @Test
    public void bits() {
        int[] input = { 3, 5, 7, 8, 10, 12, 15 };
        int target = 7;

        int result = BinarySearch.search(input, target);

        assertEquals(2, result);
    }
}
