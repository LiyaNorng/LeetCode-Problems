class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 0;
        int current;
        if (nums.length > 0){
            if (nums[0] != 0){ 
                current = 0; 
            }
            else {
                current = -1;
            }
        }
        else { 
            return 0; 
        }
        for (int j = 0; j < nums.length; j++){
            if (current != nums[j]){
                nums[i++] = nums[j];
            }
            current = nums[j];  
        }
        return i;
    }
}