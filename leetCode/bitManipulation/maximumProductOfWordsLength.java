class Solution {
    public int maxProduct(String[] words) {
        int[] charSet = new int[words.length];
        for(int i=0; i<words.length; i++){
            charSet[i] = 0;
            for(int j=0; j<words[i].length(); j++){
                charSet[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        int max = 0;
        for(int i=0; i<words.length-1; i++){
            for(int j=i+1; j<words.length; j++){
                if((charSet[i]&charSet[j])==0 && (words[i].length()*words[j].length())>max)
                    max = words[i].length()*words[j].length();
            }
            
        }
        return max;
    }
}