class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> wordMem = new HashMap<>();        
        return helper(s, wordDict, wordMem);
    }
    
    public boolean helper(String s, List<String> wordDict, Map<String, Boolean> wordMem){
        if(wordDict.contains(s)) return true;
        if(wordMem.containsKey(s)) return wordMem.get(s);
        
        for(int i=1; i<=s.length(); i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(wordDict.contains(right)){
                boolean check = helper(left, wordDict, wordMem);
                wordMem.put(left, check);
                
                if(check){
                    wordMem.put(s,true);
                    break;
                }
            }
        }
        
        if(!wordMem.containsKey(s)) wordMem.put(s,false);
        
        return wordMem.get(s);
    }
}