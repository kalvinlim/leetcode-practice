import linkedlist.LinkedListUtils;
import linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddTwo {
    @Test
    public void addTwoSimple(){
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(5);

        ListNode expected = LinkedListUtils.createList(0,1);
        ListNode result = addTwoNumbers(one, two);

        assertTrue(LinkedListUtils.equalLinkLists(expected, result));
    }

    @Test
    public void addUneven(){
        ListNode one = LinkedListUtils.createList(9,8);
        ListNode two = LinkedListUtils.createList(1);

        ListNode result = addTwoNumbers(one, two);
        ListNode expected = LinkedListUtils.createList(0,9);
        assertTrue(LinkedListUtils.equalLinkLists(result, expected));
    }

    @Test
    public void addTwoDoubleDigit(){
        ListNode one = LinkedListUtils.createList(9,9);
        ListNode two = LinkedListUtils.createList(9,9);

        ListNode expected = LinkedListUtils.createList(8,9,8);
        ListNode result = addTwoNumbers(one, two);

        assertTrue(LinkedListUtils.equalLinkLists(expected, result));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode p = new ListNode(0);
        ListNode head = p;
        boolean carry = false;
        while(l1.next != null && l2.next != null){
            int value = (l1.val+l2.val);
            if(carry){
                value++;
            }

            if(l1.val+l2.val >= 10){
                carry = true;
            } else {
                carry = false;
            }
            value = value%10;

            p.next = new ListNode(value);
            p = p.next;

            System.out.println(value);
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1.next == null && l2.next != null){
            int value = l2.val;
            if(carry){
                value++;
            }

            if(l2.val == 9){
                carry = true;
            } else {
                carry = false;
            }
            value = value%10;

            p.next = new ListNode(value);
            p = p.next;

            System.out.println(value);
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1.next != null && l2.next == null){
            int value = l1.val;
            if(carry){
                value++;
            }

            if(l2.val == 9){
                carry = true;
            } else {
                carry = false;
            }
            value = value%10;

            p.next = new ListNode(value);
            p = p.next;

            System.out.println(value);
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1.next==null && l2.next==null){
            int value = (l1.val+l2.val)%10;
            System.out.println(value);
            if(carry) {
                p.next = new ListNode(value+1);
            } else {
                p.next = new ListNode(value);
            }
            p = p.next;

            if((l1.val+l2.val) >= 10){
                System.out.println(1);
                p.next = new ListNode(1);
            }

        }


        return head.next;
    }



}
