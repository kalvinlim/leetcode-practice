package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingTemplate {

    //Permutations II
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrackII(nums, used, new ArrayList<>(), result);
        return result;
    }

    //Base case
    //Choose
    //Explore
    //Backtrack
    private void backtrackII(int[] nums, boolean[] used, List<Integer> currentPath, List<List<Integer>> result) {
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Extra Step 2: Skip identical elements under specific conditions
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            currentPath.add(nums[i]);

            backtrackII(nums, used, currentPath, result);

            currentPath.remove(currentPath.size() - 1);
            used[i] = false;
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
