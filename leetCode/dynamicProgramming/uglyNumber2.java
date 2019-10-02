class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        for(int i=1; i<n; i++){
            int min = Math.min(Math.min(n2,n3),n5);
            nums[i] = min;
            n2 = (min==n2)?2*nums[++i2]:n2;
            n3 = (min==n3)?3*nums[++i3]:n3;
            n5 = (min==n5)?5*nums[++i5]:n5;
        }
        
        return nums[n-1];
    }
}