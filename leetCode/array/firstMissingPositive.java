class Solution {
    public int firstMissingPositive(int[] nums) {
        int replace = -1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                replace = nums[i];
                break;
            }   
        }
        
        if(replace == -1) return 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0) nums[i] = replace;
        }
        
        for(int i=0;i<nums.length;i++){
            int cur = Math.abs(nums[i]);
            if(cur>0&&cur<=nums.length){
                nums[cur-1] = -Math.abs(nums[cur-1]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return i+1; 
        }
        return nums.length+1;
        
    }
}