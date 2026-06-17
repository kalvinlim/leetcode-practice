package stairs;

public class ClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Base variables tracking min cost to reach the previous two steps
        int first = cost[0];
        int second = cost[1];

        // Iteratively calculate the min cost for subsequent steps
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }

        // The top of the floor can be reached from either of the last two steps
        return Math.min(first, second);
    }
}
