import linkedlist.LinkedListUtils;
import linkedlist.ListNode;
import org.junit.Test;

public class SwapPairs {
    @Test
    public void swapPairsTest(){
        ListNode input = LinkedListUtils.createList(2,1);

        swapPairs(input);
    }

    public static ListNode swapPairs(ListNode head){
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode p2 = head.next;

        while(p2 != null){

            System.out.println("p1=" + p.val + ", p2="+p2.val);

            p.next = p2.next;
            p2.next = p;

            p = p.next;
            p2 = p2.next;

            String foo = "";
        }


        return head;
    }
}
