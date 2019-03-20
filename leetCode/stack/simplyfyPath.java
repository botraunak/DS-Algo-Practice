class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] splitted = path.trim().split("/");
        for(String s: splitted){
            if(!s.isEmpty()){
                if("..".equals(s)){
                    if(!stack.empty())
                        stack.pop();
                } else if(".".equals(s)){
                    continue;
                } else {
                    stack.push(s);
                }
            }
        }
        
        if(stack.empty())
            return "/";
        
        String sb = new String("");
        while(!stack.empty()){
            sb = "/" + stack.pop() + sb;
        }
        
        return sb;
    }
}