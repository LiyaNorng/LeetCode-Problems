class Solution {
    public int orangesRotting(int[][] grid) {
        
        //boolean [][]visit = new boolean [grid.length][grid[0].length];
        Pair<Integer, Integer> pair;
        Queue<Pair> queue = new ArrayDeque<>();
        
        int i = -1;
        int j = 0;
        int freshFruit = 0;
        for (int t = 0; t < grid.length; t++){
            for (int y = 0; y < grid[0].length; y++){
                if (grid[t][y] == 1){
                    freshFruit++;
                }
                else if (grid[t][y] == 2){
                    queue.add(new Pair<>(t, y));
                }
            }
        }
        if (queue.isEmpty() && freshFruit > 0){
            return -1;
        }
        else if (queue.isEmpty() && freshFruit == 0){
            return 0;
        }

        int [] row = {-1, 0, 0, 1};
        int [] col = {0, -1, 1, 0};
        int res = 0;
        //System.out.println(freshFruit);
        while(!queue.isEmpty() && freshFruit > 0){
            int s = queue.size();
            res++;
            while(s-- > 0){
                pair = queue.poll();
                i = pair.getKey();
                j = pair.getValue();
                for(int k = 0; k < 4; k++){
                    if (valid(grid, i + row[k], j + col[k])){
                        //visit[i + row[k]][j + col[k]] = true;
                        freshFruit--;
                        grid[i + row[k]][j + col[k]] = 2;
                        queue.add(new Pair<>(i + row[k], j + col[k]));
                    }
                }
            }
            
        }
        //System.out.println(count);
        return freshFruit == 0 ? res : -1;
    }
    
    public boolean valid(int [][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
    }
}