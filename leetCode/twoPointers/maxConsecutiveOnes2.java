class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max1 = 0, one = 0;
        int zero = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1)
                one++;
            else{
                one = i-zero;
                zero = i;
            }
            max1 = Math.max(max1, one);
        }
        
        return max1;
    }
}