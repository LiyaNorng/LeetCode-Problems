class Solution {
    
    public int[] row = {-1, 0, 0, 1};
    public int[] col = {0, -1, 1, 0};
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0){
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    BFS(grid, queue);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public void BFS(char[][] grid, Queue<int[]> queue){
        if(queue.isEmpty()){
            return;
        }
        int[] k = queue.poll();
        for(int i = 0; i < 4; i++){
            if(valid(grid, row[i] + k[0], col[i] + k[1])){
                grid[row[i] + k[0]][col[i] + k[1]] = '0';
                queue.add(new int[] {row[i] + k[0], col[i] + k[1]});
            }
        }
        BFS(grid, queue);
    }
    
    public boolean valid(char[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1';
    }
}