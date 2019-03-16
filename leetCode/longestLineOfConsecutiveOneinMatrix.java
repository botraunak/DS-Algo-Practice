public class Solution {
    
    public int longestLine(int[][] M){
        if(M.length==0)
            return 0;
            
        int ans = 0;
        int[][][] dp = new int[M.length][M[0].length][4];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(M[i][j]==1){
                    dp[i][j][0] = j>0 ? dp[i][j-1][0]+1:1;
                    dp[i][j][1] = i>0 ? dp[i-1][j][1]+1:1;
                    dp[i][j][2] = (i>0 && j>0) ? dp[i-1][j-1][2]+1:1;
                    dp[i][j][3] = (i>0 && j<dp[0].length-1) ? dp[i-1][j+1][3]+1:1;
                    ans = Math.max(ans, Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));
                }
            }
        }
        
        return ans;
    }
}