class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max_sum = dp[0];
        for (int i=1; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i - 2 >= 0) dp[i] = Math.max(dp[i], dp[i-2] + nums[i]);
            if (i - 3 >= 0) dp[i] = Math.max(dp[i], dp[i-3] + nums[i]);
            if (max_sum < dp[i]) max_sum = dp[i];
        }
        return max_sum;
    }
}