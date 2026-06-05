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

    //1. Base Case
    //2. Choices
    //3. Constraints
    //4. Backtracking step
    private static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, boolean[] used) {
        for(int i=0; i<currentList.size(); i++) {
            if(used[i]) {
                continue;
            }


            currentList.add(nums[i]);
        }
    }

    public static void findSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

    }
}
