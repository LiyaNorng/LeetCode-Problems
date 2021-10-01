class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(prices.length == 0 || k <= 0){
            return 0;
        }
        
        if(k >= prices.length){
            int res = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){
                    res += prices[i] - prices[i - 1];                
                }
            }
            return res;
        }
        
        int[][][] dp = new int[prices.length][k + 1][2];
            
        for(int i = 0; i < prices.length; i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        
        for(int i = 0; i <= k; i++){
            dp[0][i][1] = -prices[0];
        }
        
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                res = Math.max(res, Math.max(dp[i][j][0], dp[i][j][1]));
                
            }
        }
        return Math.max(res, 0);
    }
}