class Solution {
    public boolean isNumber(String s) {
        boolean sign = false;
        boolean e = false;
        boolean decimal = false;
        boolean digit = false;
        
        s = s.trim();
        
        if(s.length() == 0)
            return false;
        
        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i)) && s.charAt(i) != 'e')
                return false;
            if(s.charAt(i) == 'e' && (e || !digit))
                return false;
            if(s.charAt(i) == '.' && (decimal || e))
                return false;
            if((s.charAt(i) == '+' || s.charAt(i) == '-') && (sign || digit || (decimal && !e)))
                return false;
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                sign = true;
                continue;
            }
            if(s.charAt(i) == '.'){
                decimal = true;
                continue;
            }
            if(s.charAt(i) == 'e'){
                e = true;
                digit = false;
                sign = false;
                continue;
            }
            if(Character.isDigit(s.charAt(i))){
                digit = true;
                continue;
            }
            return false;
        }
        
        if(sign && !digit)
            return false;
        if(decimal && !digit)
            return false;
        if(e && !digit)
            return false;
        
        return true;
    }
}