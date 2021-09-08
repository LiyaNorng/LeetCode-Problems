class Solution {
    public int mySqrt(int x) {
        
        if(x <= 1){
            return x;
        }
        
        long left = 0; 
        long right = x;
        long res = 0;
        while(left <= right){
            long mid = left + (right - left) / 2;
            
            if(mid * mid == x){
                return (int)mid;
            }
            
            if(mid * mid > x){
                right = mid - 1;
            }
            else{
                res = mid;
                left = mid + 1;
            }
        }
        return (int)res;   
    }
}