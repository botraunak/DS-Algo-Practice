class Solution {
    
    public String simplifyPath(String path) {
        Stack<String> dirs = new Stack<String>();
        
        StringBuilder directoryBuilder = new StringBuilder();
        int opCount = 0;
        for (int i=0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                opCount++;
                if (opCount <= 1) {
                    String s = directoryBuilder.toString();
                    if (s.equals("..")) {
                        if (!dirs.isEmpty()) dirs.pop();
                    }
                    else if (!s.equals(".") && !s.isEmpty()) {
                        dirs.push(s);
                    }
                    directoryBuilder = new StringBuilder();
                }
            } else {
                opCount = 0;
                directoryBuilder.append(c);
            }
        }
        
        String s = directoryBuilder.toString();
        if (s.equals("..")) {
            if (!dirs.isEmpty()) dirs.pop();
        }
        else if (!s.equals(".") && !s.isEmpty()) {
            dirs.push(s);
        }
        
        if (dirs.isEmpty()) return "/";
    
        String canonicalPath = new String("");
        while (!dirs.isEmpty()) {
            canonicalPath = "/" + dirs.pop() + canonicalPath;
        }
        
        return canonicalPath;
    }
}