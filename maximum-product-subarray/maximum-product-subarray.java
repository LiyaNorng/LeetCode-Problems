class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int prod = 1, max = nums[0];
        for(int i = 0; i < nums.length; i++){
            prod *= nums[i];
            max = Math.max(max, prod);
            if (prod == 0){
                prod = 1;
            }
        }
        
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            prod *= nums[i];
            max = Math.max(max, prod);
            if (prod == 0){
                prod = 1;
            }
        }
        return max;        
    }
}