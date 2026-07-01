package stacksAndHeaps;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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



}
