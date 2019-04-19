class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++)
            Arrays.fill(memo[i], -1);
        return helper(word1,word2,memo,0,0);
    }
    
    public int helper(String w1, String w2, int[][] memo, int i, int j){
        if(w1.length() == i) return w2.length()-j;
        if(w2.length() == j) return w1.length()-i;
        if(memo[i][j] != -1) return memo[i][j];
        
        if(w1.charAt(i)==w2.charAt(j))
            memo[i][j] = helper(w1,w2,memo,i+1,j+1);
        else
            memo[i][j] = Math.min(helper(w1,w2,memo,i+1,j+1), Math.min(helper(w1,w2,memo,i+1,j),helper(w1,w2,memo,i,j+1))) + 1;
        return memo[i][j];
    }
}