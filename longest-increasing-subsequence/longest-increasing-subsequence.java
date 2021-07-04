class Solution {
    
    
    /**
    
    Goal: Find the length of longest increasing subsequence.
    
    State: dp[i] = the length of longest increaing subsequence at end of i.
    
    Base case: 
    
    dp[0] = 1;
    int res = 0 max length of the longest increasing subsequence in dp[i]
    
    transition / recurrence relation:
    
    1 Options : 
     1.) take an element at i if nums[i] > nums[j] with condition for all j < i;
     for all nums[j] < nums[i]
        dp[i] = Math.max(dp[j], dp[i]);
    
    dp[i] += 1;
    res = Math.max(res, dp[i]);
   
    **/

    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int sum = 1;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] = dp[i] + 1;
            sum = Math.max(sum, dp[i]);
        }
        
        return sum;

    }
}