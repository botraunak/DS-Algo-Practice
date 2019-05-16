class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                res = Math.max(helper(matrix, dp, i, j), res);
            }
        }
        
        return res;
    }
    
    public int helper(int[][] matrix, int[][] dp, int x, int y){
        if(dp[x][y] > 0) return dp[x][y];
        
        int max = 0;
        if(x>0 && matrix[x-1][y]<matrix[x][y]){
            max = Math.max(max, helper(matrix, dp, x-1, y));
        }
        if(y>0 && matrix[x][y-1]<matrix[x][y]){
            max = Math.max(max, helper(matrix, dp, x, y-1));
        }
        if(x<matrix.length-1 && matrix[x+1][y]<matrix[x][y]){
            max = Math.max(max, helper(matrix, dp, x+1, y));
        }
        if(y<matrix[0].length-1 && matrix[x][y+1]<matrix[x][y]){
            max = Math.max(max, helper(matrix, dp, x, y+1));
        }
        dp[x][y] = max+1;
        return dp[x][y];        
    }
}