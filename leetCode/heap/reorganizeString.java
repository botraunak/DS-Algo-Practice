class Solution {
    public String reorganizeString(String S) {
        int[] ch = new int[26];
        int len = S.length();
        int check = (len+1)/2;
        for(char c: S.toCharArray()){
            ch[c-'a']++;
            if(ch[c-'a']>check){
                return "";
            }
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        for(int i=0; i<26; i++){
            if(ch[i]>0){
                heap.offer(new int[]{ch[i],i});
            }
        }
        
        char[] s = new char[len];
        int i = 0;
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            while(curr[0]>0){
                s[i%len] = (char)(curr[1]+'a');
                i+=2;
                if(i==len) i++;
                curr[0]--;
            }
        }
        return new String(s);
    }
}