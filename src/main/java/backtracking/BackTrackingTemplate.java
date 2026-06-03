package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingTemplate {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, boolean[] used) {
        // Base case: if our current permutation is the same size as the input, we found a valid permutation
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Recursive case
        for (int i = 0; i < nums.length; i++) {
            System.out.println("==================================");
            System.out.println("CHOOSE");
            System.out.println("CURRENT I= " + i);
            // Skip if the number has already been used in this path
            System.out.println("SHOULD SKIP: " + used[i]);
            if (used[i]) continue;

            // Choose
            used[i] = true;
            currentList.add(nums[i]);
            System.out.println("Adding to currentList: " + nums[i]);
            System.out.println("Used: " + java.util.Arrays.toString(used));

            // Explore
            backtrack(result, currentList, nums, used);

            // Un-choose (Backtrack)
            used[i] = false;
            System.out.println("UNCHOOSE- Current remove: " + Arrays.toString(used) + ", removing: " + currentList.get(currentList.size() -1));
            currentList.remove(currentList.size() - 1);
        }
    }
}
