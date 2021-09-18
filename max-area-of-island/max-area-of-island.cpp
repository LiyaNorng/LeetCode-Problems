class Solution {
public:
    
    #define s 4
    int col[s] {0, -1, 1, 0};
    int row[s] {-1, 0, 0, 1};
    int running = 0;
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        
        vector<vector<bool>> visited (grid.size(), vector<bool> (grid[0].size(), false));
        
        int max = 0;
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    DFS(grid, visited, i, j);
                    running++;
                    max = std::max(max, running);
                    running = 0;
                }
            }
        }
        return max;    
    }
    
    void DFS(vector<vector<int>>& grid, vector<vector<bool>>& visited, int i, int j){
        
        visited[i][j] = true;
        
        for(int k = 0; k < s; k++){
            if(valid(grid,visited, row[k] + i, col[k] + j)){
                running++;
                DFS(grid, visited, row[k] + i, col[k] + j);
            }
        }   
    }
    
    bool valid(vector<vector<int>>& grid, vector<vector<bool>>& visited, int row, int col){
        return row >= 0 && row < grid.size() && col >= 0 && col < grid[0].size() && grid[row][col] == 1 && !visited[row][col];
    }
    
};