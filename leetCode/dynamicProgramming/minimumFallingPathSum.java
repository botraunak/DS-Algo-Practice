class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        for(int col = 0; col<A[0].length; col++)
            dp[0][col] = A[0][col];
        
        for(int row=1; row<A.length; row++){
            for(int col = 0; col<A[0].length; col++){
                dp[row][col] = A[row][col];
                if(col-1>=0 && col+1<A[0].length){
                    dp[row][col] += Math.min(dp[row-1][col-1], Math.min(dp[row-1][col], dp[row-1][col+1]));
                } else if(col-1>=0){
                    dp[row][col] += Math.min(dp[row-1][col-1], dp[row-1][col]);
                } else if(col+1<A[0].length){
                    dp[row][col] += Math.min(dp[row-1][col+1], dp[row-1][col]);
                } else{
                    dp[row][col] += dp[row-1][col];
                }
            }
        }
        
        int ans = dp[A.length-1][0];
        for(int col = 1; col<A[0].length; col++){
            if(dp[A.length-1][col] < ans)
                ans = dp[A.length-1][col];
        }
        
        return ans;
    }
}