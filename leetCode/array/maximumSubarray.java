class Solution {
    public int maxSubArray(int[] nums) {
        int end = 0;
        int max_sum = nums[0], sum = nums[0];
        
        while(end<nums.length-1){
            end++;
            if(nums[end]>sum && sum < 0){
                sum = 0;
            }
            sum += nums[end];
            if(sum>max_sum){
                max_sum = sum;
            }
        }
        
        return max_sum;
    }
}