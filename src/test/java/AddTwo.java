import linkedlist.LinkedListUtils;
import linkedlist.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwo {


    @Test
    public void addTwoSimple(){
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(5);

        ListNode result = addTwoNumbers(one, two);

        System.out.println("result: ");
        LinkedListUtils.printAll(result);
    }

    @Test
    public void addUneven(){
        ListNode one = new ListNode(1);
        one.next = new ListNode(8);
        ListNode two = new ListNode(0);

        ListNode result = addTwoNumbers(one, two);

        System.out.println("result: ");
        LinkedListUtils.printAll(result);
    }

    @Test
    public void addTwoDoubleDigit(){
        ListNode one = new ListNode(5);
        one.next = new ListNode(6);
        ListNode two = new ListNode(5);
        two.next = new ListNode(6);

        ListNode result = addTwoNumbers(one, two);

        System.out.println("result: ");
        LinkedListUtils.printAll(result);
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
