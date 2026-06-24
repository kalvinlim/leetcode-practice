package binning;

public class Knapsack {
    //Leetcode 416
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, we cannot partition it into two equal halves
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];

        // Base case: a sum of 0 is always achievable (empty subset)
        dp[0] = true;

        // Process each number
        for (int num : nums) {
            // Traverse backwards to prevent using the same element multiple times
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }

            // Optimization: If we already found a way to reach the target, exit early
            if (dp[target]) {
                return true;
            }
        }

        return dp[target];

    }
}
