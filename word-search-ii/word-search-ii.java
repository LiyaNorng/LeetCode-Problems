class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        boolean[][] visited;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                for(int k = 0; k < words.length; k++){
                    
                    char[] c = words[k].toCharArray();
                    if(board[i][j] == c[0] && !words[k].equals("0")){
                        visited = new boolean [board.length][board[0].length];
                        if(DFS(board, c, visited, 0, i, j)){
                            res.add(words[k]);
                            words[k] = "0";
                        }
                    }
                }
            }
        } 
        return res;  
    }
    
    public boolean DFS(char[][] board, char[] c, boolean[][] visited, int index, int i, int j){
        
        if(!valid(i, j, board, c, index, visited)){
            return false;
        }
        if(index == c.length - 1){
            return true;
        }
        
        //char temp = board[i][j];
        visited[i][j] = true;        
        if(DFS(board, c, visited, index + 1, i + 1, j) || DFS(board, c,visited, index + 1, i - 1, j) || DFS(board, c, visited, index + 1, i, j + 1) || DFS(board, c, visited, index + 1, i, j - 1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
    
    public boolean valid(int row, int col, char[][] board, char[] c, int index, boolean[][] visited){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && index < c.length && c[index] == board[row][col] && !visited[row][col];
    }

}