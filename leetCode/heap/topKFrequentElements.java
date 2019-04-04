class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!countMap.containsKey(nums[i]))
                countMap.put(nums[i], 0);
            countMap.put(nums[i], countMap.get(nums[i])+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue(k, new ValueComparator());
        for(Map.Entry<Integer,Integer> e: countMap.entrySet()){
            if(k>0){
                heap.add(e);
            } else if(e.getValue() > heap.peek().getValue() && e.getKey() != heap.peek().getKey()){
                heap.poll();
                heap.add(e);
            }
            k--;
        }
        List<Integer> res = new ArrayList<>();
        while(!heap.isEmpty()){
            res.add(heap.poll().getKey());
        }
        
        return res;
    }
    
    public class ValueComparator implements Comparator<Map.Entry<Integer,Integer>>{
        public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2){
            return e1.getValue()-e2.getValue();
        }
    }
}