class Solution {
    
    int[] row = {-1, 0, 0, 1};
    int[] col = {0, -1, 1, 0};
    public int countBattleships(char[][] board) {
        
        int res = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    res++;
                    DFS(board, i , j);
                }
            }
        }
        
        return res;
    }
    
    public void DFS(char[][] board, int i, int j){
        
        board[i][j] = '.';
        for(int k = 0; k < row.length; k++){
            if(valid(board, i + row[k], j + col[k])){
                DFS(board, i + row[k], j + col[k]);
            }
        }
        
    }
    
    public boolean valid(char[][] board, int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'X'; 
    }
}