package stacksAndHeaps;

import java.util.*;

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

    //Leetcode 496
    //Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    //Output: [-1,3,-1]
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        
        for(int i=nums2.length-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                map.put(nums2[i],stack.peek());
            }

            stack.push(nums2[i]);
        }
        System.out.println(map);
        for(int i=0;i<nums1.length;i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }



}
