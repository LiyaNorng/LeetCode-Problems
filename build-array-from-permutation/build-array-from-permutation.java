class Solution {
    public int[] buildArray(int[] nums) {
        
        int temp = 0;
        int j = 0;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = nums[nums[i]];
        }
        
        return res;
    }
}