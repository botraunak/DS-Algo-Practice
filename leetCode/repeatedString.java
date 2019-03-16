class Solution {
    public int repeatedStringMatch(String A, String B) {
        
        int rep =  B.length()/A.length();
        
        String test = String.join("", Collections.nCopies(rep, A));
        
        if(test.contains(B))
            return rep;
        
        rep++;
        test = String.join("", Collections.nCopies(rep, A));
        if(test.contains(B))
            return rep;
        
        rep++;
        test = String.join("", Collections.nCopies(rep, A));
        if(test.contains(B))
            return rep;
            
        return -1;
    }
}