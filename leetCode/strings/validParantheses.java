class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        
        if(s.length() == 1)
            return false;
        
        Stack<Character> paran = new Stack<>();
        paran.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++){
            if(!paran.empty()){
                char top = paran.peek();
                if(top=='[' && ']' == s.charAt(i)){
                    paran.pop();
                    continue;
                }
                if(top=='{' && '}' == s.charAt(i)){
                    paran.pop();
                    continue;
                }
                if(top=='(' && ')' == s.charAt(i)){
                    paran.pop();
                    continue;
                }
            }
            
            paran.push(s.charAt(i));
        }
        
        if(paran.empty())
            return true;
        
        return false;
        
    }
}