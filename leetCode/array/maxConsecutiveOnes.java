class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max1 = 0, temp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1)
                continue;
            else{
                if(max1<i-temp)
                    max1 = i-temp;
                temp = i+1;
            }
        }
        if(max1<nums.length-temp)
            max1 = nums.length-temp;
        
        return max1;
    }
}