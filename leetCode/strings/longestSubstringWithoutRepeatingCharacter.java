class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int start = 0;
        
        Map<Character, Integer> idx = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            if(idx.containsKey(s.charAt(i))){
                if(len < i-start){
                    len = i-start;
                }
                if(idx.get(s.charAt(i))+1 > start)
                    start = idx.get(s.charAt(i))+1;
            }            
            idx.put(s.charAt(i), i);
            
            
        }
        if(len < s.length()-start){
            len = s.length()-start;
        }
        
        return len;
    }
}