class Solution {
    public boolean backspaceCompare(String S, String T) {
        int s = S.length()-1;
        int t = T.length()-1;
        
        int s_back = 0;
        int t_back = 0;
        
        boolean same = true;
        
        while(s>=0 || t>=0){
            
            while((s_back >= 0 || S.charAt(s) == '#') && s>=0){
                if(S.charAt(s) == '#'){
                    s_back++;
                    s--;
                } else if (s >= 0 && s_back > 0){
                    s_back--;
                    s--;
                } else
                    break;
            }
            
            while((t_back >= 0 || T.charAt(t) == '#') && t>=0){
                if(T.charAt(t) == '#'){
                    t_back++;
                    t--;
                } else if (t >= 0 && t_back > 0){
                    t_back--;
                    t--;
                } else
                    break;
            }
            
            if(s<0 && t<0)
                break;
            
            if ((s < 0 && t >=0) || (t < 0 && s >=0)){
                same = false;
                break;
            }
            
            if(S.charAt(s) != T.charAt(t)){
                same = false;
                break;
            }
            
            if(s>=0)
                s--;
            if(t>=0)
                t--;
        }
        
        return same;
    }
}