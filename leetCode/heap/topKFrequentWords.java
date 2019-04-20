class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(!countMap.containsKey(words[i]))
                countMap.put(words[i], 0);
            countMap.put(words[i], countMap.get(words[i])+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue(k, new ValueComparator());
        for(Map.Entry<String,Integer> e: countMap.entrySet()){
            if(k>0){
                heap.add(e);
            } else if(e.getValue() > heap.peek().getValue()){
                heap.poll();
                heap.add(e);
            } else if(e.getValue() == heap.peek().getValue() && e.getKey().compareTo(heap.peek().getKey())<0){
                heap.poll();
                heap.add(e);
            }
            k--;
        }
        List<String> res = new ArrayList<>();
        while(!heap.isEmpty()){
            res.add(0, heap.poll().getKey());
        }
        
        return res;
    }
    
    public class ValueComparator implements Comparator<Map.Entry<String,Integer>>{
        public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2){
            if(e1.getValue()!=e2.getValue())
                return e1.getValue()-e2.getValue();
            return e2.getKey().compareTo(e1.getKey());
        }
    }
}
