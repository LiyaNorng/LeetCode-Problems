class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return topDown(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length, new HashMap<>());
    }
    
    public int topDown(int[][] matrix, int m, int n, int M, int N, HashMap<Pair, Integer> hash){
        if(m >= M || n >= N || matrix[m][n] == 1){
            return 0;
        }
        
        if(m == M - 1 && n == N - 1){
            return 1;
        }
        
        Pair<Integer, Integer> pair = new Pair<>(m, n);
        if(hash.containsKey(pair)){
            return hash.get(pair);
        }
        int k = topDown(matrix, m + 1, n, M, N, hash) + topDown(matrix, m, n + 1, M, N, hash);
        hash.put(pair, k);
        return hash.get(pair);
    }
}