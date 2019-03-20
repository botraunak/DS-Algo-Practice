class Solution {
    
    public String simplifyPath(String path) {
        Stack<String> dirs = new Stack<String>();
        
        StringBuilder directoryBuilder = new StringBuilder();
        int opCount = 0;
        char[] patha = path.toCharArray();
        for (int i=0; i < patha.length; i++) {
            char c = patha[i];
            if (c == '/') {
                opCount++;
                if (opCount == 1) {
                    String s = directoryBuilder.toString();
                    if (s.equals("..")) {
                        if (!dirs.isEmpty()) dirs.pop();
                    }
                    else if (!s.equals(".") && !s.isEmpty()) {
                        dirs.push(s);
                    }
                    directoryBuilder.setLength(0);
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
    
        directoryBuilder.setLength(0);
        while (!dirs.isEmpty()) {
            directoryBuilder.insert(0, "/" + dirs.pop());
        }
        
        return directoryBuilder.toString();
    }
}