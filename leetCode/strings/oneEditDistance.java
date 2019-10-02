class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        for(int i=0; i<s.length() && i<t.length(); i++){
            if(s.charAt(i) != t.charAt(i))
                return helper(s,t,i,i+1) || helper(s,t,i+1,i+1) || helper(s,t,i+1,i);
        }
        return Math.abs(s.length()-t.length())==1;
    }
    
    public boolean helper(String w1, String w2, int i, int j){
        while(i<w1.length() && j<w2.length() && w1.charAt(i) == w2.charAt(j)){
            i++;
            j++;
        }
        return i==w1.length() && j==w2.length();
    }
}