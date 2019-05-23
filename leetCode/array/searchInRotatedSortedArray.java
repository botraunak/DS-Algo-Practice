class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int p = findPivot(nums);
        System.out.println(p);
        if(p == nums.length-1)
            return binarySearch(nums, 0, p, target);
        if(target == nums[0]) return 0;
        if(target > nums[0]){
            return binarySearch(nums, 0, p, target);
        } else
            return binarySearch(nums, p+1, nums.length-1, target);
    }
    
    public int binarySearch(int[] arr, int l, int h, int t){
        int mid = (l+h)/2;
        if(arr[mid] == t) return mid;
        while(l<=h){
            mid = (l+h)/2;
            if(arr[mid] == t)
                return mid;
            if(arr[mid]<t)
                l = mid+1;
            else
                h = mid-1;
        }
        return -1;
    }
    
    public int findPivot(int[] nums){
        int l=0,r=nums.length-1;
        int mid;
        while(l<r){
            mid = (l+r)/2;
            if(mid-1>=l){
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[l]){
                    l = mid;
                    continue;
                } else {
                    r = mid;
                    continue;
                }
            }
            if(mid+1<=r){
                if(nums[mid]<nums[mid+1] && nums[mid]<nums[r]){
                    l = mid+1;
                    continue;
                } else {
                    r = mid;
                    continue;
                }
            }
        }
        
        return l;
    }
}