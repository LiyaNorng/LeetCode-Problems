class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        
        /**
        if (nums.length < 2){
            return new ArrayList<>(new ArrayList<>());
        }
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int lo = 0;
        int hi = 0;
        int len = nums.length;
        List<Integer> temp = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < len; i++){
            
            lo = i + 1;
            hi = len - 1;
            
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                
                if(sum == 0){
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    String key = nums[i] + "-" + nums[lo] + "-" + nums[hi];
                    if(!hash.containsKey(key)){
                        res.add(temp);
                        hash.put(key, 0);
                    }
                }
                
                if(sum > 0){
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }
        return res;  
    }
}
        
        
        **/
        if(nums.length < 2){
            return new ArrayList(new ArrayList());
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
 
        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                int k = nums.length - 1;
                int j = i + 1;
                while(j < k){
                    //System.out.println(nums[i] + " " + "  " + nums[j] + "  " + nums[k]);
                    if (nums[i] + nums[j] + nums[k] == 0 ){
                        list.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                        while(j < k && nums[j] == nums[j + 1]){
                            //System.out.println("j loop " + nums[i] + " " + "  " + nums[j] + "  " + nums[k]);
                            j++;
                        }
                        while(j < k && nums[k] == nums[k - 1] ){
                            //System.out.println("k loop " + nums[i] + " " + "  " + nums[j] + "  " + nums[k]);
                            k--;
                        }
                        j++;
                        k--;
                    }
                    else if (nums[i] + nums[j] + nums[k] > 0){
                        k--;
                    }
                    else{
                        j++;
                    }
                }
     
            }  
        }
        return list;
    }
}  
        
        
      /*  

        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> threeSum = new ArrayList<List<Integer>>();
        int left = 0, right = nums.length - 1, mid = 0;
        
        while(left <= right){
        
            mid = left + (right - left) / 2;
            
            if(nums[mid] == 1){
                break;
            }
            else if(nums[mid] < 1){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        for(int i : nums){
            System.out.print(i + " ");
        }
                    System.out.println("");
        System.out.println(mid);
        threeSum = new ArrayList<>();
        for(int i = 0 ; i < mid;i++ ){
            if(nums[i] > 0){
                break;
            }
            if( i == 0 || (i != 0 && nums[i - 1] != nums[i])){
                
            
            //System.out.print(nums[i] + "  ");
                for(int j = i + 1; j < nums.length - 1; j++){

                    if( j < nums.length - 1 && nums[j] != nums[j + 1]){
                        System.out.print(nums[i] + " "+ nums[j] +  "     ");
                        if(nums[j] > 0 && nums[i] > 0){
                            break;
                        }
                        for(int k = j + 1; k < nums.length; k++){
                            if(k < nums.length && nums[k] != nums[k - 1] ){
                                System.out.print(nums[i] + " "+ nums[j] + " "+ nums[k] + "     ");
                                if(nums[i] + nums[j] + nums[k] > 0 && nums[k] > 0){
                                    break;
                                }
                                if(nums[i] + nums[j] + nums[k] == 0 && !threeSum.contains(Arrays.asList(nums[i], nums[j], nums[k]))){
                                    threeSum.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                                }
                            }
                        }
                    }
                }
            }
        }

        return threeSum;
    }  
}


*/