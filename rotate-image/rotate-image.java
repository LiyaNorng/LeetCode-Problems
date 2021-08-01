class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
        int left = 0;
        int right = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++){
            left = 0;
            right = matrix[0].length - 1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
    }
}