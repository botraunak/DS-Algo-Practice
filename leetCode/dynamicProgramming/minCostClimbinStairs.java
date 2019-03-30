class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i < cost.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i - 1 >= 0) dp[i] = Math.min(dp[i], dp[i-1] + cost[i]); 
            if (i - 2 >= 0) dp[i] = Math.min(dp[i], dp[i-2] + cost[i]);
            if (i - 1 < 0 && i -2 < 0) dp[i] = cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}