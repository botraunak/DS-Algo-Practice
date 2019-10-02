class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        
        int len = 0;
        int start = 0;
        int count = 0;
        char[] str = s.toCharArray();
        
        int[] idx = new int[256];
        Arrays.fill(idx, -1);
        
        for(int i=0; i<str.length; i++){
            if(idx[str[i]] == -1){
                if(count==k){
                    len = (len < i-start)?i-start:len;
                    int min = str.length;
                    int pos = 0;
                    for(int j =0; j<256; j++){
                        if(min > idx[j] && idx[j] != -1){
                            min = idx[j];
                            pos = j;
                        }
                    }
                    start = min+1;
                    idx[pos] = -1;
                    count--;
                }
                count++;
            }
            idx[str[i]] = i;
        }
        if(len < s.length()-start){
            len = s.length()-start;
        }
        
        return len;
    }
}