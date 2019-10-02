class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<int[]> res = new ArrayList<>();
        int nl1 = nums1.length, nl2 = nums2.length;
        if(nl1*nl2 <= k){
            for(int i=0; i<nl1; i++){
                for(int j=0; j<nl2; j++){
                    res.add(new int[]{nums1[i], nums2[j]});
                }
            }
            return res;
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue(new ArrayComparator());
        for(int i=0; i<nl1; i++){
            for(int j=0; j<nl2; j++){
                if(maxHeap.size()<k){
                    maxHeap.add(new int[]{nums1[i], nums2[j]});
                } else{
                    int[] temp = maxHeap.peek();
                    if(temp[0]+temp[1] > nums1[i]+nums2[j]){
                        maxHeap.poll();
                        maxHeap.add(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        
        while(!maxHeap.isEmpty()){
            res.add(0, maxHeap.poll());
        }
        
        return res;
    }
    
    public class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] n1, int[] n2){
            return n2[0]+n2[1]-(n1[0]+n1[1]);
        }
    }
}