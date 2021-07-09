class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int len = nums.length;
        int j = 0;
        int k = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < len && diff != 0; ++i){
            
            j = i + 1;
            k = len - 1;
            
            while(j < k){
                
                int sum = nums[i] + nums[j] + nums[k];
                
                if (Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                
                if (sum < target){
                    ++j;
                }
                else{
                    --k;
                }
            }
        }
        return target - diff;
  
        /**
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            j = 0;
            k = nums.length - 1;
            while(j < nums.length && k >= 0){
                list.add(nums[i] + nums[j] + nums[k]);
                j++;
                k--;
            }
        }
        
        Collections.sort(list);
        int i = 0;
        for(; i < list.size() - 1; i++){
            System.out.println(list.get(i));
            if(list.get(i) > target){
                break;
            }
        }
        if(i - 1 >= 0){
            int low = list.get(i - 1);
            int high = list.get(i);
            low = Math.abs(low - target);
            high = Math.abs(high - target);
            if(low < high){
                return list.get(i - 1);
            }
            else{
                return list.get(i);
            }
        }
        return list.get(i);
        
        **/
    }
}