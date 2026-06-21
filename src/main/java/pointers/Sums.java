package pointers;

import java.util.*;

public class Sums {
    public static int[] twoSum(int[] nums, int target){
        // Map to store numbers and their corresponding indices
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists in the map, we found the pair
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            // Otherwise, store the current number and its index
            numMap.put(nums[i], i);
        }

        // Return empty array if no solution is found (though constraints guarantee one)
        return new int[] {};
    }

    //Leetcode 167, two pointers algorithm
    public static int[] twoSumSorted(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // The problem requires 1-indexed results
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++; // Sum is too small, move to a larger value
            } else {
                right--; // Sum is too large, move to a smaller value
            }
        }

        // Return an empty array if no solution is found (guaranteed not to happen per constraints)
        return new int[]{-1, -1};
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. Sort the array
        Arrays.sort(nums);

        // 2. Iterate through the array to fix the first element
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Optimization: If the current lowest number is greater than 0,
            // no three numbers can sum up to 0.
            if (nums[i] > 0) {
                break;
            }

            // 3. Initialize two pointers for the remaining subarray
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid unique triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, move left pointer to increase the value
                    left++;
                } else {
                    // Sum is too large, move right pointer to decrease the value
                    right--;
                }
            }
        }

        return result;
    }
}
