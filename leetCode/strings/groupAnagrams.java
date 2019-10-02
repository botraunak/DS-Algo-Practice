class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        
        Map<String, List> res = new HashMap();
        int[] cc = new int[26];
        StringBuilder sb = new StringBuilder();
        String key;
        for(int i=0; i<strs.length; i++){
            Arrays.fill(cc, 0);
            for(char c: strs[i].toCharArray()){
                cc[c-'a'] += 1; 
            }
            sb.setLength(0);
            for(int j=0; j<26; j++)
                sb.append("#"+cc[j]);
            key = sb.toString();
            if(!res.containsKey(key)) res.put(key, new ArrayList());
            res.get(key).add(strs[i]);
        }
        return new ArrayList(res.values());
    }
}