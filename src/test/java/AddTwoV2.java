import linkedlist.LinkedListUtils;
import linkedlist.ListNode;
import org.junit.Test;

public class AddTwoV2 {
    @Test
    public void addTwoSimple(){
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(5);

        ListNode expected = LinkedListUtils.createList(0,1);
        ListNode result = addTwoNumbers(one, two);


        //assertTrue(LinkedListUtils.equalLinkLists(expected, result));
    }

    @Test
    public void addUneven(){
        ListNode one = LinkedListUtils.createList(9,8);
        ListNode two = LinkedListUtils.createList(1);

        ListNode result = addTwoNumbers(one, two);
        ListNode expected = LinkedListUtils.createList(0,9);
        //assertTrue(LinkedListUtils.equalLinkLists(result, expected));
    }

    @Test
    public void addTwoDoubleDigit(){
        ListNode one = LinkedListUtils.createList(9,9);
        ListNode two = LinkedListUtils.createList(9,9);

        ListNode expected = LinkedListUtils.createList(8,9,8);
        ListNode result = addTwoNumbers(one, two);

        //assertTrue(LinkedListUtils.equalLinkLists(expected, result));
    }

    public ListNode addTwov2(ListNode l1, ListNode l2){
        while(l1.next != null && l2.next!=null){

            System.out.println(l1.val + " + " +l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode p = new ListNode(0);
        ListNode head = p;
        boolean carry = false;

        while(l1 != null || l2 != null){
            int val1  = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;


            String result = val1 + " + " + val2;

            if(carry){
                result+= " + " + 1;
            }

            System.out.println(result);
            carry = (val1+val2) > 9 ? true : false;

            if(l1 != null) { l1 = l1.next; }
            if(l2 != null) { l2 = l2.next; }
        }

        if(carry){
            System.out.println("1");
        }

        return head.next;
    }



}
