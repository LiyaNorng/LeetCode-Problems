class Solution {
    
    int[] row = {-1, 0, 0, 1, 1, -1, 1, -1};
    int[] col = {0, -1, 1, 0, 1, 1, -1, -1};
    public void gameOfLife(int[][] board) {
        
            
        int r = board.length;
        int c = board[0].length;
        int[][] dp = new int[r][c];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                dp[i][j] = board[i][j];
            }
        }
        
        int cell = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                cell = 0;
                for(int k = 0; k < row.length; k++){
                    if(valid(dp, i + row[k], j + col[k])){
                        cell++;
                    }
                }
                populate(board, cell,i,j);
            }
        } 
    }
    
    public boolean valid(int[][] board, int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 1;
    }
    
    public void populate(int[][] board, int cell, int i, int j){
        
        if(board[i][j] == 1){
            
            if(cell < 2){
                board[i][j] = 0;
            }
            else if(cell == 2 || cell == 3){
                /// do nothing;
            }
            else{
                board[i][j] = 0;
            }
        }
        else{
            if(cell == 3){
                board[i][j] = 1;
            }
        }
        
    }
}