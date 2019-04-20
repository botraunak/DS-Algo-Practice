class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points.length<=K) return points;
        int[][] res = new int[K][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new DistComparator());
        for(int i=0; i<points.length; i++){
            if(maxHeap.size()<K)
                maxHeap.offer(points[i]);
            else{
                if(compare(maxHeap.peek(), points[i])<0){
                    maxHeap.poll();
                    maxHeap.offer(points[i]);
                }                
            }
        }
        int i=0;
        while(!maxHeap.isEmpty()){
            res[i++] = maxHeap.poll();
        }
        return res;
    }
    
    public int compare(int[] e1, int[] e2){
        return (Math.sqrt(e2[0]*e2[0]+e2[1]*e2[1]))>(Math.sqrt(e1[0]*e1[0]+e1[1]*e1[1]))?1:-1;
    }
    
    public class DistComparator implements Comparator<int[]>{
        public int compare(int[] e1, int[] e2){
            return (Math.sqrt(e2[0]*e2[0]+e2[1]*e2[1]))>(Math.sqrt(e1[0]*e1[0]+e1[1]*e1[1]))?1:-1;
        }
    }
}