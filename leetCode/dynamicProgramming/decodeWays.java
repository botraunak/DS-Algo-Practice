class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        int[] memo = new int[len+1];
        memo[len] = 1;
        memo[len-1] = s.charAt(len-1)=='0'?0:1;
        for(int i=len-2; i>=0; i--){
            if(s.charAt(i) == '0') continue;
            memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26)?memo[i+1]+memo[i+2]:memo[i+1];
        }
        return memo[0];
    }
}