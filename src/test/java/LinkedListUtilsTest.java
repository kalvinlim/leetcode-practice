import linkedlist.LinkedListUtils;
import linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListUtilsTest {

    @Test
    public void equalTest(){
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(2);

        assertFalse(LinkedListUtils.equalLinkLists(one, two));
    }

    @Test
    public void equalTest_whenEqual_expectTrue(){
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(3);

        assertTrue(LinkedListUtils.equalLinkLists(one, two));
    }

    @Test
    public void equalTest_whenEqualLengthsOnly_expectFalse(){
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(4);
        two.next = new ListNode(5);
        two.next.next = new ListNode(6);

        assertFalse(LinkedListUtils.equalLinkLists(one, two));
    }

    @Test
    public void createListTest(){
        ListNode result = LinkedListUtils.createList(1,2,3,4,5);
        ListNode expected = new ListNode(1);

        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);
        expected.next.next.next.next = new ListNode(5);

        assertTrue(LinkedListUtils.equalLinkLists(expected, result));
    }

}
