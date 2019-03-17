class Solution {
    
    private int[][] co= { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, 
                                  { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];
        int liveN = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                liveN = 0;
                for(int k=0; k<8; k++){
                    if( i+co[k][0] >=0 && i+co[k][0] < board.length
                        && j+co[k][1] >=0 && j+co[k][1] < board[0].length){
                        if(board[i+co[k][0]][j+co[k][1]] == 1)
                            liveN++;
                    }
                }
                if (liveN < 2) temp[i][j] = 0;
                else if (liveN >= 2 && liveN <= 3 && board[i][j] == 1) temp[i][j] = 1;
                else if (liveN > 3) temp[i][j] = 0;
                else if (liveN == 3 && board[i][j] == 0) temp[i][j] = 1;
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = temp[i][j];
            }
        }
    }
}