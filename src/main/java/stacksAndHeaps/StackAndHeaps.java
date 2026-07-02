package stacksAndHeaps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class StackAndHeaps {
    public static int calculateDiscountedTotal(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] updatedPrices = prices.clone();

        for(int i=0;i<prices.length;i++) {
            while(!stack.isEmpty() && prices[i] <= updatedPrices[stack.peek()]) {
                int currentIndex = stack.peek();
                updatedPrices[currentIndex] -= prices[i];
                stack.pop();
            }
            stack.push(i);
        }

        int total = 0;

        for(int price : updatedPrices) {
            total+=price;
        }

        return total;
    }

    public static int[] nextLargerElement(int[] arr) {
        int[] result = new int[arr.length];
        for(int i=0;i<result.length;i++) {
            result[i] = -1;
        }
        // Stack stores indices in decreasing order of their values
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=arr.length-1; i>=0;i--){
            // Pop all elements smaller than current element
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return result;
    }



}
