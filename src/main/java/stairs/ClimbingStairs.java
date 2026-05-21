package stairs;

public class ClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        // Base case values for step 0 and step 1
        int prev2 = 0; // Represents dp[i-2]
        int prev1 = 0; // Represents dp[i-1]

        // Loop from step 2 up to the top floor (cost.length)
        for (int i = 2; i <= cost.length; i++) {
            // Step 1: Calculate the minimum cost to reach the current step
            int current = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            System.out.println("Currently at " + i + ". Calculating using Min(" + prev1 + " + " + cost[i - 1] + ", " + prev2 + " + " + cost[i - 2] + ") = " + current + ". Current="+ current);
            

            // Step 2: Slide the window variables forward
            prev2 = prev1;
            prev1 = current;
            System.out.println("----------------------------------------------");
        }

        System.out.println("Prev2 = " + prev2);
        System.out.println("Prev1 = " + prev1);
        // After the loop, prev1 holds the cost to reach the top floor
        return prev1;
    }
}
