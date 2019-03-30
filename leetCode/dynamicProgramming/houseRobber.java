class Solution {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;
        int temp;
        for(int i=0; i<nums.length; i++){
            temp = prev2;
            prev2 = Math.max(prev1, prev2);
            prev1 = nums[i]+temp;
        }
        return Math.max(prev1, prev2);
    }
}