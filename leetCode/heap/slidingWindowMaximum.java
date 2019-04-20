class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length==0) return new int[]{};
        int len = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[len-k+1];
        int n = 0;
        for(int i=0; i<len; i++){
            while(!q.isEmpty() && q.peek() < i-k+1)
                q.poll();
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
                q.pollLast();
            q.offer(i);
            if(i>=k-1)
                res[n++] = nums[q.peek()];
        }
        return res;
    }
}