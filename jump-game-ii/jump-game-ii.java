class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n - 1);
        dp[0] = 0;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.min(nums[i] + i , n - 1);
            for(int j = i + 1; j <= max; j++){
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        
        return dp[n - 1];
        
    }
}