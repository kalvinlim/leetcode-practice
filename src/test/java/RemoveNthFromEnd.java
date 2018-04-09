import linkedlist.LinkedListUtils;
import linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RemoveNthFromEnd {

    @Test
    public void foo3(){
        ListNode input = LinkedListUtils.createList(1,2);

        ListNode expected = LinkedListUtils.createList(2);
        ListNode result = removeNthFromEnd(input, 2);

        LinkedListUtils.printAll(result);
        assertTrue(LinkedListUtils.equalLinkLists(expected, result));
    }

    @Test
    public void foo(){
        ListNode input = LinkedListUtils.createList(1,2,3,4);

        ListNode expected = LinkedListUtils.createList(2,3,4);
        ListNode result = removeNthFromEnd(input, 4);

        assertTrue(LinkedListUtils.equalLinkLists(expected, result));
        LinkedListUtils.printAll(result);
    }

    @Test
    public void foo2(){
        ListNode input = LinkedListUtils.createList(1);

        ListNode expected = LinkedListUtils.createList();
        ListNode result = removeNthFromEnd(input, 1);

        LinkedListUtils.printAll(result);
        assertTrue(LinkedListUtils.equalLinkLists(expected, result));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode start = p;
        ListNode end = p;

        for(int i=0;i<n;i++){
            end = end == null ? null : end.next;
        }

        while(end != null){
            end = end.next;
            start = start.next;
        }

        //start.val = start.next == null ? null : start.next.val;
        if(start.next == null){
            start = null;
        } else {
            start.val = start.next.val;
            start.next = start.next.next;
        }

        System.out.println("start: " + start + ", end: " + end);

        return p;
    }
}
