class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0)
            return 0;
        
        int rowlen = grid.length;
        int collen = grid[0].length;
        int[][] dp = new int[rowlen][collen];
        
        for(int row=0; row<rowlen; row++){
            for(int col=0; col<collen; col++){
                dp[row][col] = grid[row][col];
                
                if(row-1>=0 && col-1>=0){
                    dp[row][col] += Math.min(dp[row-1][col], dp[row][col-1]);
                } else if(row-1>=0){
                    dp[row][col] += dp[row-1][col];
                } else if(col-1>=0){
                    dp[row][col] += dp[row][col-1];
                }
            }
        }
        
        return dp[rowlen-1][collen-1];
    }
}