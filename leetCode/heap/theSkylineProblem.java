class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> cpHeights = new ArrayList<>();
        for(int[] b: buildings){
            cpHeights.add(new int[]{b[0], b[2]});
            cpHeights.add(new int[]{b[1], -b[2]});
        }
        
        Collections.sort(cpHeights, (a,b)-> {
            if(a[0]!=b[0])
                return a[0]-b[0];
            return b[1]-a[1];
        });
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(b-a));
        heap.offer(0);
        int max = 0;
        for(int[] h: cpHeights){
            if(h[1]>0)
                heap.offer(h[1]);
            else
                heap.remove(-h[1]);
            int curr = heap.peek();
            if(max!=curr){
                res.add(new int[]{h[0],curr});
                max = curr;
            }
        }
        return res;
    }
}