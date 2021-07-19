class Solution {
    public boolean find132pattern(int[] nums) {
        
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(min[i - 1] > nums[i]){
                min[i] = nums[i];
            }
            else{
                min[i] = min[i - 1];
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--){
            if(min[i] < nums[i]){
                while(!stack.isEmpty() && stack.peek() <= min[i]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        
        return false;
        
        
        
        
        
        /**
        int[] min = new int[nums.length];
        int i = 0;
        min[i++] = nums[0];
        for(; i < nums.length; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
     
        Stack<Integer> stack = new Stack<>();
        
        for(int k = nums.length - 2; k > 0; k--){
        
            if(!stack.isEmpty() && stack.peek()  nums[k] && stack.peek() <= min[k] )
            
            if(!stack.isEmpty() && stack.peek() >= nums[k] && stack.peek() <= min[k] ){
                stack.pop();
            }
            else{
                stack.push(nums[k]);
            }
            
        }
      
        return false;
        **/
    }
}