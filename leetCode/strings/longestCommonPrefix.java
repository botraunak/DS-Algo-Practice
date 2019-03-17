class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i=1; i<strs.length; i++){
            int j;
            for(j=0; j<strs[i].length() && j<ans.length(); j++){
                if(!(ans.charAt(j)==strs[i].charAt(j)))
                    break;
            }
            if(j<ans.length())
                ans = ans.substring(0, j);
            if(ans.equals(""))
                break;
        }
        return ans;
    }
}