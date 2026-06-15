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

    @Test
    public void tryingMinHeap() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(10);
        minHeap.add(1);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // prints 1 then 3 then 10
        }
     }
}
