class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        
        int one = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                one = 1;
            }
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
            
        }
        
        if(one == 0){
            return 1;
        }
        
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            index = Math.abs(nums[i]);
            if(index == nums.length){
                nums[0] = -1 * Math.abs(nums[0]);
            }
            else{
                nums[index] = -1 * Math.abs(nums[index]);
            }
            
        }
        
        for(int i = 1; i < nums.length; i++){
            //System.out.println(nums[i]);
            if(nums[i] > 0){
                return i;
            }
        }
        //System.out.println(nums[0]);
        return nums[0] > 0 ? nums.length: nums.length + 1;
    }
}