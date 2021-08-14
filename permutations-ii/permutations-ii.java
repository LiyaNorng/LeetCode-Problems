class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Set<List<Integer>> list = new HashSet<>();
        backTrack(list, nums, 0);
        return new ArrayList(list);
     
    }
    
    
    public void backTrack(Set<List<Integer>> list, int[] nums, int index){
        
        if(index == nums.length - 1){
            List<Integer> temp = new LinkedList<>();
            for(int i : nums){
                temp.add(i);
            }
            list.add(temp);
            return;
        }
        
        for(int i = index; i < nums.length; i++){

            swap(nums, i, index);
            backTrack(list, nums, index + 1);
            swap(nums, i, index);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}