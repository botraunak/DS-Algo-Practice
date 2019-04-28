class Solution {
    public String addBoldTag(String s, String[] dict) {
        if(dict == null || dict.length == 0) return s;
        int[] set = new int[s.length()+1];
        int index = -1;
        for(String str : dict){
            index = s.indexOf(str, index);
            while(index != -1){
                Arrays.fill(set, index, index+str.length(), 1);
                index += 1;
                index = s.indexOf(str, index);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(set[0]==1){
            sb.append("<b>" + s.charAt(0));
        } else {
            sb.append(s.charAt(0));
        }
        for(int i=1; i<=s.length(); i++){
            if(set[i]==1 && set[i-1]==0) sb.append("<b>");
            if(set[i]==0 && set[i-1]==1) sb.append("</b>");
            if(i<s.length())
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}