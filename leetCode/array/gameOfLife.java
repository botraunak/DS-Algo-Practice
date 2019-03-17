class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] res = new int[m][n];
        for (int i=0; i < m; i++) {
            for (int j=0;  j < n; j++) {
                int liveN = 0;
                int deadN = 0;
                if (j > 0) {
                    if (board[i][j-1] == 0) deadN++;
                    else liveN++;
                }
                if (j < n - 1) {
                    if (board[i][j+1] == 0) deadN++;
                    else liveN++;
                }
                if (i > 0) {
                    if (board[i - 1][j] == 0) deadN++;
                    else liveN++;   
                }
                if (i < m - 1) {
                    if (board[i + 1][j] == 0) deadN++;   
                    else liveN++;
                }
                if (i > 0 && j > 0) {
                  if (board[i-1][j-1] == 0) deadN++;
                  else liveN++;  
                } 
                if (i > 0 && j < n - 1) {
                    if (board[i-1][j+1] == 0) deadN++;
                    else liveN++;   
                }
                if (i < m - 1 && j > 0) {
                    if (board[i+1][j-1] == 0) deadN++;
                    else liveN++;
                } 
                if (i < m - 1 && j < n - 1) {
                  if (board[i+1][j+1] == 0) deadN++;
                  else liveN++;  
                } 
                
                if (liveN < 2) res[i][j] = 0;
                else if (liveN >= 2 && liveN <= 3 && board[i][j] == 1) res[i][j] = 1;
                else if (liveN > 3) res[i][j] = 0;
                else if (liveN == 3 && board[i][j] == 0) res[i][j] = 1;
            }
        }
        
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}