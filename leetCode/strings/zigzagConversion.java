class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int curr = 0;
        int start = 0;
        int row = 0;
        int skips = 0;
        int toSkip = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(s.charAt(0));
        for (int i=0; i < s.length() - 1; i++) {
            toSkip = (numRows - row - 1)*2;
            if (skips%2 == 1) {
                toSkip = (numRows - 1)*2 - toSkip;
            }
            toSkip = (toSkip == 0) ? (numRows - 1)*2 : toSkip;
            
            if (curr + toSkip < s.length()) {
                curr = curr + toSkip;
                builder.append(s.charAt(curr));   
                skips++;
            } else {
                start++;
                curr = start;
                builder.append(s.charAt(curr));
                row++;
                skips = 0;
            }
            
        }
        
        return builder.toString();
    }
}