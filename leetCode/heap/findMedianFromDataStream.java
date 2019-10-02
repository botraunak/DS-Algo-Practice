class MedianFinder {
    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;
    int[] nums;
    int size;

    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        if(lo.size()<hi.size()) lo.offer(hi.poll());
    }
    
    public double findMedian() {
        return lo.size()>hi.size()?lo.peek():(lo.peek()+hi.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */