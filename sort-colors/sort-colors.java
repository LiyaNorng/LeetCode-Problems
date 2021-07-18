class Solution {
    public void sortColors(int[] nums) {
        
        int zero = 0;
        int one = 0;
        int two = 0;
        
        for(int i : nums){
            if(i == 0){
                zero++;
            }
            else if(i == 1){
                one++;
            }
            else{
                two++;
            }        
        }
        
        int i;
        for( i = 0; i < nums.length; i++){
            if(zero > 0){
                nums[i] = 0;
            }
            else{
                break;
            }
            zero--;
        }
        for(; i < nums.length; i++){
            if(one > 0){
                nums[i] = 1;
            }
            else{
                break;
            }
            one--;
        }
        for( ; i < nums.length; i++){
            if(two > 0){
                nums[i] = 2;
            }
            else{
                break;
            }
            two--;
        }
    }
}