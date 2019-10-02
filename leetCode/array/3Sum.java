/**
 * 3 Sum Problem
 * https://leetcode.com/problems/3sum/
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i < n; i++) {
            if (nums[i] > 0) break;
            int l = i+1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l = upperBound(nums, l, r, nums[l]) + 1;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
            
            i = upperBound(nums, i, n-1, nums[i]);
        }    
        return res;
    }
    
    
    public static int upperBound(int[] arr, int low, int high, int el) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean nextDiff = true;
            if ((mid + 1) < arr.length) {
                nextDiff = arr[mid+1] != arr[mid];
            }
            if (arr[mid] == el && nextDiff) return mid;
            else if (arr[mid] <= el) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}