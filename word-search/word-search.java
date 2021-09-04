class Solution {

    int[] row = {0, -1, 1, 0};
    int[] col = {-1, 0, 0, 1};
    public boolean exist(char[][] board, String word) {
    
        char[] c = word.toCharArray();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(c[0] == board[i][j]){
                    if(DFS(board, c, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    
    }
    
    public boolean DFS(char[][] board, char[] c, int i, int j, int index){
        
        if(!valid(board, c, i, j, index)){
            return false;
        }
        
        if(index >= c.length){
            return false;
        }
        
        if(index == c.length - 1){
            return true;
        }
        
        char temp = board[i][j];
        board[i][j] = '0';
        for(int k = 0; k < row.length; k++){
            if(DFS(board, c, i + row[k], j + col[k], index + 1)){
                return true;
            }
        }
        
        board[i][j] = temp;
        
        return false;  
    }
    
    public boolean valid(char[][] board, char[] c, int row, int col, int index){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && index < c.length && board[row][col] == c[index];
    }
    
}