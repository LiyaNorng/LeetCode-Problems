class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        backTrack(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
    public void backTrack(int[] nums, List<List<Integer>> res, List<Integer> list, int i){
        
        res.add(new ArrayList<>(list));

        for(; i < nums.length; i++){
            list.add(nums[i]);
            backTrack(nums, res, list, i + 1);
            list.remove(list.size() - 1);
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }
        
    }
}