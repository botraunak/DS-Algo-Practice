class Solution {
    
    private int start = 0, len = 0;
    
    public String longestPalindrome(String s) {
        if(s.length() < 2)
            return s;
        for(int i =0; i<s.length(); i++){
            maxPalindromeAround(s, i, i);
            maxPalindromeAround(s, i, i+1);
        }
        return s.substring(start, start+len);
    }
    
    public void maxPalindromeAround(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        if(len < right-left-1){
            len = right-left-1;
            start = left+1;
        }
    }
}