package backtracking;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingTemplate {
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
