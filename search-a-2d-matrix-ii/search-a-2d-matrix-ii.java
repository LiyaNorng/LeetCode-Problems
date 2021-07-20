class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        int row = matrix.length - 1;
        while(i <= row){
            int left = 0;
            int right = j;
            while(left <= right){
                int middle = left + (right - left)/2;
                if(matrix[i][middle] == target){
                    return true;
                }

                if(matrix[i][middle] < target){
                    left = middle + 1;
                }
                else{
                    right = middle - 1;
                }
            }
            i++;
        }
        return false;
    }
}