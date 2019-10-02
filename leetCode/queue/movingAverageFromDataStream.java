class MovingAverage {
    int size;
    double avg;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.avg = 0;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        double sum = avg*queue.size() + val;
        queue.add(val);
        if(queue.size()>size){
            sum = sum - queue.poll();
        }
        avg = sum/queue.size();
        return avg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */