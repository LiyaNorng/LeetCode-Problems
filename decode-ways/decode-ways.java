class Solution {
    public int numDecodings(String s) {
        
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= s.length(); i++){
            int singleInt = Integer.valueOf(s.substring(i - 1, i));
            int doubleInt = Integer.valueOf(s.substring(i - 2, i));
            
            if(singleInt > 0){
                dp[i] += dp[i - 1];
            }
            if(doubleInt > 9 && doubleInt <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}