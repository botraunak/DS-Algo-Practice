class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length==0) return 1;
        int[] n = new int[nums.length+2];
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0 && nums[i]<=nums.length+1)
                n[nums[i]] = 1;
        }
        for(int i=1; i<n.length; i++){
            if(n[i]==0)
                return i;
        }
        return nums.length;
    }
}