package linkedlist;

import java.util.ArrayList;

public class LinkedListUtils {

    public static boolean equalLinkLists(ListNode one, ListNode two){
        if(one == null && two == null){
            return true;
        } else if( (one == null || two == null)){
            return false;
        }

        ArrayList<Integer> oneArray = toArray(one);
        ArrayList<Integer> twoArray = toArray(two);

        return oneArray.equals(twoArray);
    }

    private static ArrayList<Integer> toArray(ListNode node){
        ListNode temp = node;

        ArrayList<Integer> result = new ArrayList<>();

        while(temp.next != null){
            result.add(temp.val);
            temp = temp.next;
        }
        result.add(temp.val);

        return result;
    }


    public static void printAll(ListNode node){
        while(node.next != null){
            System.out.print(node.val+",");
            node = node.next;
        }
        if(node.next == null){
            System.out.println(node.val);
        }
    }
}
