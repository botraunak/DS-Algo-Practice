class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        
        int stringLen = S.length();
        int queries = indexes.length;
        TreeMap<Integer, Integer> idx = new TreeMap<Integer, Integer>();
        
        int i;
        
        for(i=0; i<queries; i++){
            if(S.startsWith(sources[i], indexes[i])){
                idx.put(indexes[i], i);
            }
        }
        
        i=0;
        StringBuilder builder = new StringBuilder("");
        for(Integer id: idx.keySet()){
            if(i<=id){
                builder.append(S.substring(i, id));
                builder.append(targets[idx.get(id)]);
                i = id + sources[idx.get(id)].length();
            }
        }
        
        if(i<stringLen){
            builder.append(S.substring(i));
        }
        
        return builder.toString();
        
    }
}