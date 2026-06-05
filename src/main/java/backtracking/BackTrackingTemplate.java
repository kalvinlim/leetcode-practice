package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingTemplate {

    //Permutations II
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to group duplicates together
        Arrays.sort(nums);
        // Track which elements are used in the current path
        boolean[] used = new boolean[nums.length];
        backtrackII(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrackII(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // Base case: a complete permutation is found
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in the current path
            if (used[i]) {
                continue;
            }

            // Skip duplicates: if the current element is identical to the previous one,
            // and the previous one was not used in this branch, it means we already
            // fully explored that exact value configuration.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrackII(nums, used, current, result);

            // Un-choose (Backtrack)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    //1. Base Case
    //2. Choices
    //3. Constraints
    //4. Backtracking step
    private static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, boolean[] used) {
        if(currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
        }
        for(int i=0; i<nums.length; i++) {
            if(used[i]) {
                continue;
            }

            used[i] = true;
            currentList.add(nums[i]);
            backtrack(result, currentList, nums, used);

            used[i] = false;
            currentList.removeLast();
        }
    }


    public static void backtrackPermuations(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));

        for(int i=start; i<nums.length; i++) {
            tempList.add(nums[i]);
            backtrackPermuations(result, tempList, nums, i+1);
            tempList.removeLast();

        }
    }

    public static void findSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

    }
}
