class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int base = 0;
        int level = 1;
        int mul = (numRows-level)*2;
        StringBuilder sb = new StringBuilder();
        
        while(base<s.length()){
            sb.append(s.charAt(base));
            base += mul;
        }
        
        base = 1;
        level = 2;
        
        while(level<numRows){
            mul = (numRows-level)*2;
            
            if(base < s.length()){
                sb.append(s.charAt(base));
                base += mul;
            }
            
            if(base < s.length()){
                sb.append(s.charAt(base));
            }
            
            mul = (level-1)*2;
            
            base += mul;
            
            if(base > s.length()){
                base = level;
                level++;
            }
        }
        
        base = level-1;
        
        mul = (level-1)*2;
        
        while(base<s.length()){
            sb.append(s.charAt(base));
            base += mul;
        }
        
        return sb.toString();
    }
}