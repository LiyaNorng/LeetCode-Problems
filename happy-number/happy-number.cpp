class Solution {
public:
    bool isHappy(int n) {
        if(n == 1){
            return true;
        }
        else if(n == 4){
            return false;
        }
        else{
            int rem = 0;
            int res = 0;
            while(n > 0){
                rem = n % 10;
                n /= 10;
                res += pow(rem, 2);
            }
            return isHappy(res);
        }
        
    }
};