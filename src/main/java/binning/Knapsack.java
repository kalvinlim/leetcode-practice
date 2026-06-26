package binning;

import java.util.Arrays;

public class Knapsack {

    //Leetcode 416
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num: nums) {
            for(int j=target; j>= num; j--) {
                dp[j] = dp[j] || dp[j-num];
            }

            if(dp[target]) {
                return true;
            }
        }
        return dp[target];
    }

    //Leetcode 416
    public static boolean canPartitionDebug(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it cannot be divided into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[j] will be true if a subset sum of j is possible
        boolean[] dp = new boolean[target + 1];

        // Base case: A sum of 0 is always possible (by picking an empty subset)
        dp[0] = true;

        System.out.println("Input: " + Arrays.toString(nums));
        // Process each number in the input array
        for (int num : nums) {
            // Loop backwards to ensure we use each number at most once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
                System.out.println("Num: "+ num + ", "+"j="+j+", dp[" + j + "] = (dp[" + j + "] || dp[" + j + "-" + num + "]) -> (" + dp[j] + "||" + dp[j-num] + "). dp: " + Arrays.toString(dp));
            }
            System.out.println("-------------------------");
            // Optimization: If we already found a way to reach the target, exit early
            if (dp[target]) {
                System.out.println("Early Exit: dp["+ target + "] = " + dp[target] + " dp: " + Arrays.toString(dp));
                return true;
            }
        }

        return dp[target];
    }

    //Leetcode 494
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Edge cases based on mathematical derivation
        if (Math.abs(target) > sum || (sum + target) % 2 != 0 || (sum + target) < 0) {
            return 0;
        }

        int subsetTarget = (sum + target) / 2;
        int[] dp = new int[subsetTarget + 1];
        dp[0] = 1; // Base case: 1 way to make a sum of 0

        // Dynamic programming transition
        for (int num : nums) {
            for (int j = subsetTarget; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetTarget];
    }
}
