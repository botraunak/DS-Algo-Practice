class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for(int i=0; i<s.length(); i++){
            if(arr[s.charAt(i)-'a'] == -1){
                arr[s.charAt(i)-'a'] = i;
                continue;
            } else {
                arr[s.charAt(i)-'a'] -= (i+1);
            }
        }
        
        int ans = s.length();
        
        for(int i=0; i<26; i++){
            if(arr[i]>=0 && ans>arr[i])
                ans = arr[i];
        }
        
        if(ans == s.length())
            return -1;
        
        return ans;
    }
}