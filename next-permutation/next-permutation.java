class Solution {
    public void nextPermutation(int[] nums) {
        
        int i = nums.length -2;
        
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        
        if(i >= 0){
            int j = nums.length - 1;
            
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        //System.out.println(nums[i]);
        reverse(nums,i + 1, nums.length - 1);  
    }
    
    public void reverse(int[] num, int a, int b){

        while(a < b){
            swap(num, a, b);
            a++;
            b--;
        }
    }
    
    public void swap(int[] num, int a, int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    
}