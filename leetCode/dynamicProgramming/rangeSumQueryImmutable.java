class NumArray {
    
    private int[] nums;
    private int[] dp;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if(dp == null){
            dp = new int[nums.length];
            dp[0] = nums[0];
        
            for(int k=1; k<nums.length; k++){
                dp[k] = nums[k]+dp[k-1];
            }
        }
        
        return dp[j]-dp[i]+nums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */