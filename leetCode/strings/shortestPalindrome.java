class Solution {
    public String shortestPalindrome(String s) {
        int mid = s.length()/2;
        if(s.length()%2 == 0){
            if(checkPalin(s, mid-1, mid))
                return s;
            mid--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=mid; i>0 ; i--){
            if(checkPalin(s,i,i)){
                sb.append(s.substring(2*i+1));
                sb = sb.reverse();
                sb.append(s);
                return sb.toString();
            }
            if(checkPalin(s,i-1,i)){
                sb.append(s.substring(2*i));
                sb = sb.reverse();
                sb.append(s);
                return sb.toString();
            }
        }
        
        sb.append(s.substring(1));
        sb = sb.reverse();
        sb.append(s);
        return sb.toString();
    }
    
    public boolean checkPalin(String s, int left, int right){
        while(left>=0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left--;
            right++;
        }
        return true;
    }
}