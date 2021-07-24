class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return helper(nums, k) - helper(nums, k - 1);
    }
    
    public int helper(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int res = 0;
        while(j < nums.length){
            
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() > k && i <= j){
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            
            res += j - i - 1;
            j++;
        }
        return res;
    }
}