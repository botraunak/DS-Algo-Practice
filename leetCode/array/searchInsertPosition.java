class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = (l+r)/2;
        
        while(l<=r){
            if(nums[mid] == target)
                return mid;
            if(target < nums[mid]){
                r = mid-1;
            }
                
            if(target > nums[mid]){
                l = mid+1;
            }
                
            mid = (l+r)/2;
        }
        
        return l;
    }
}