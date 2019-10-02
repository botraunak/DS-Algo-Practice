class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, mx_a = 0;
        while(left<right){
            mx_a = Math.max(mx_a, (right-left)*Math.min(height[left], height[right]));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return mx_a;
    }
}