class Solution {
    public int trap(int[] height) {
        
        
        int lo = 0;
        int hi = height.length - 1;
        int res = 0;
        int lower = 0;
        int level = 0;
        while(lo < hi){
            lower = height[ height[lo] < height[hi] ? lo++ : hi--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        
        return res;

        
        /**
        int[] dp = new int[height.length];
        int max = 0;
        for(int i = 0; i < height.length; ++i){
            dp[i] = max;
            max = Math.max(max, height[i]);
        }
        
        max = 0;
        int res = 0;
        for(int i = height.length - 1; i >=0; --i){
            dp[i] = Math.min(max, dp[i]);
            max = Math.max(max, height[i]);
            if(dp[i] - height[i] > 0){
                res += dp[i] - height[i];
            }
        }
        return res;
        **/
    }
}