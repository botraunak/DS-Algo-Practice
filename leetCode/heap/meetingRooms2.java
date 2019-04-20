class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
        List<int[]> it = Arrays.asList(intervals);
        Collections.sort(it, (a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1]-b[1];
        });
        for(int[] in: it){
            if(!minHeap.isEmpty()){
                if(minHeap.peek()<=in[0]){
                    minHeap.poll();
                }
                minHeap.add(in[1]);
            } else
                minHeap.add(in[1]);
        }
        return minHeap.size();
    }
}