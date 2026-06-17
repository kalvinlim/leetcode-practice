package stacksAndHeaps;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndHeaps {
    public static int calculateDiscountedTotal(int[] prices) {
        int[] discounted = prices.clone(); // start with original prices
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < prices.length; i++) {
            // Current price is the "first smaller" for everything on the stack above it
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                System.out.println("COMPARING CURRENT INTERATION: " + prices[i] + " to stack top " + stack.peek() + ". Popping " + stack.peek());
                int idx = stack.pop();
                discounted[idx] = prices[idx] - prices[i]; // apply discount
            }
            stack.push(i);
            System.out.println("Pushing " + i + " onto stack. Current stack state: " + stack);
        }
        // anything remaining in stack has no discount → keeps original price

        int total = 0;
        for (int p : discounted) total += p;
        return total;
    }
}
