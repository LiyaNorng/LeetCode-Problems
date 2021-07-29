class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int n = nums.length / 2;
        for(Map.Entry m : map.entrySet()){
            //System.out.println(m.getValue());
            if((int)m.getValue() > n){
                return (int)m.getKey();
            }
        }
        return 0;
    }
}