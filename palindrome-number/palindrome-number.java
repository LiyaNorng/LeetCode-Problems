class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 ){
            return false;
        }
        
        int r = x;
        int sum = 0;
        int d = 0;
        while (x != 0){
            d = x % 10;
            sum = sum*10 + d;
            x = x/10;
        }

        if (r == sum){
            return true;
        }
        else{
            return false;
        }   
    }
}