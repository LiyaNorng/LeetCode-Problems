class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        
        int[] dp = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    dp[j] = 0;
                }
                else{
                    dp[j] += 1;
                }
            }
            //stem.out.println("got here");
            max = Math.max(max, histogram(dp));
        }
        return max;    
    }
    
    public int histogram(int[] dp){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i = 1; i < dp.length; i++){
            if(dp[i] >= dp[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && dp[i] < dp[stack.peek()]){
                    int temp = stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, dp[temp] * i);
                    }
                    else{
                        int n = dp[temp] * (i - stack.peek() - 1);
                        max = Math.max(max, n);
                    }    
                }
                
                stack.push(i);
            }
        }
        
        int j = dp.length;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(stack.isEmpty()){
                max = Math.max(dp[temp] * j, max);
            }
            else{
                int n = dp[temp] * (j - stack.peek() - 1);
                max = Math.max(max, n);
            }
        }
        return max;
    }
}