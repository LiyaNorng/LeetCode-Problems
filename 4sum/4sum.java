class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       
        if(nums.length < 3){
            return new ArrayList(new ArrayList());
        }
        Arrays.sort(nums);
        //System.out.print(Arrays.toString(nums));
        HashSet<List<Integer>> set =  new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int t = 0; t < nums.length - 3; t++){
            if(t == 0 || nums[t] != nums[t - 1]){
                for (int i = 1 + t; i < nums.length - 2; i++){
                    int k = nums.length - 1;
                    int j = i + 1;
                    while(j < k){
                    //System.out.println(nums[i] + " " + "  " + nums[j] + "  " + nums[k]);
                        if (nums[t] + nums[i] + nums[j] + nums[k] ==  target){
                            if (!set.contains(Arrays.asList(nums[t], nums[i], nums[j], nums[k]))){
                                set.add(Arrays.asList(nums[t], nums[i], nums[j], nums[k]));
                                list.add(new ArrayList(Arrays.asList(nums[t], nums[i], nums[j], nums[k])));
                            }
                            while(j < k && nums[j] == nums[j + 1]){
                                //System.out.println("j loop " + nums[i] + " " + "  " + nums[j] + "  " + nums[k]);
                                j++;
                            }
                            while(j < k && nums[k] == nums[k - 1] ){
                                //System.out.println("k loop " + nums[i] + " " + "  " + nums[j] + "  " + nums[k]);
                                k--;
                            }
                            j++;
                        }
                        else if (nums[t] + nums[i] + nums[j] + nums[k] > target){
                            k--;
                        }
                        else{
                            j++;
                        }
                    }
                }
            }
        }
        return list;       
    }
}
   