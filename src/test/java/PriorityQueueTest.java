import binarysearch.BinarySearch;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class PriorityQueueTest {

    @Before
    public void setup() {

    }

    @Test
    public void lastStoneWeight() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(2);
        maxHeap.poll();
    }
}
