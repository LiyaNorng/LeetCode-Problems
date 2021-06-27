class Solution {
    /**
    
    Goal: find the longest palindromic substring in given string
    
    State: dp[0][i] = longest palindromic substring in string s at end i
    
    Base Case:
        given length 1 string s, the longest palindromic substring is 1
        
        dp[0][0] = 1 for string length of 1  
        
    Transition / Recurrence Relations:
    
        if s[i] == s[j] wiht length 2: dp[i][j] = s[i] + s[j];
        
        if s[i] == s[j] with length greater than 2 and prev palindromic substring is true.
            dp[i][j] = s[i] + s[j];
    
        for(int length = 1; length <= s.length(); length++){ // length of substring
            for(int i = 0; i <= s.length() - length; i++){ // starting 
                for(int j = 0; j < i; j++){ // substring
                                                
                }
            }
        }
    **/
    
    public String longestPalindrome(String s) {
          
        /**  
        String[][] dp = new String[s.length()][s.length()];
        String len = "";
        
        for(int length = 1; length <= s.length(); length++){
            for(int i = 0; i <= s.length() - length; i++){
                
                int j = i + length - 1;
                
                if(length == 1){
                    dp[i][j] = Character.toString(s.charAt(i));
                    len = dp[i][j];
                    continue;
                }
                
                if(s.charAt(i) == s.charAt(j) && length == 2){
                    dp[i][j] =Character.toString(s.charAt(i)) + Character.toString(s.charAt(i));
                    len = dp[i][j];
                }
                
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != null){
                    dp[i][j] =Character.toString(s.charAt(i)) + dp[i + 1][j - 1] + Character.toString(s.charAt(i));
                    len = dp[i][j];
                }
            }
        }
       
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println( "  ");
        }
        
        return len; 
        **/
      
        String maxString = "";
        String cur = "";
        String evenCur = "";
        String temp = "";
        for (int i = 0 ; i < s.length(); i++){
            cur = getMax(s, i, i);
            evenCur = getMax(s, i , i + 1);
            if (cur.length() < evenCur.length()){
                temp = evenCur;
            }
            else{
                temp = cur;
            }
            if (maxString.length() < temp.length()){
                maxString = temp;
            }
        }
        return maxString;
    }
    
    public static String getMax(String s, int left, int right){
                
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        return s.substring(++left, right);  
    }
}