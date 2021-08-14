class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> list = new LinkedList<>();
        backTrack(list, nums,  0);
        
        return list;
        
    }
    
    public void backTrack(List<List<Integer>> list, int[] nums, int index){
        
        if(index == nums.length - 1){
            list.add(new LinkedList<>());
            for(int i : nums){
                list.get(list.size() - 1).add(i);
            }
            return;
        }
        
        for(int i = index; i < nums.length; i++){
            swap(nums, i, index);
            backTrack(list, nums,index + 1);
            swap(nums, i, index);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}