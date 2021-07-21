class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0){
            return matrix;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[i][j] = 999999;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(i > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if(j > 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1); 
                }
            }
        }
        
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(i < matrix.length - 1){
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if(j < matrix[0].length - 1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);  
                }
            }
        }
        return dp;
    }
}