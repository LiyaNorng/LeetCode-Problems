class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new LinkedList<>();
        int length = matrix.length * matrix[0].length;
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        while(list.size() < length){
            
            for(int i = left; i <= right && list.size() < length; i++){
                list.add(matrix[top][i]);
                //System.out.println(list.size() + "  repeat" );
            }
            top++;
            for(int i = top; i <= down && list.size() < length; i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i = right; i >= left && list.size() < length; i--){
                list.add(matrix[down][i]);
            }
            down--;
            for(int i = down; i >= top && list.size() < length; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}