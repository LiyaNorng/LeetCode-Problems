class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            x = 1 / x;
            return powUp(x, n);
        }
        return powDown(x, n);
    }
    
    public double powDown(double x, int n){
        if(n == 1){
            return x;
        }
        
        if(n % 2 == 0){
            return powDown(x * x, n / 2);
        }
        
        return x * powDown(x, n - 1);
    }
    
    public double powUp(double x, int n){
        if(n == -1){
            return x;
        }
        
        if(n % 2 == 0){
            return powUp(x * x, n / 2);
        }
        
        return x * powUp(x, n + 1);
    }
}