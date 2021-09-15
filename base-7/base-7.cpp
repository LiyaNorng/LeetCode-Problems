class Solution {
public:
    string convertToBase7(int num) {
        int polar = 1;
        if(num < 0){
            polar *= -1;
            num *= -1;
        }
        string res = "";
        
        while(num != 0){
            if(num / 7 == 0){
                break;
            }
            res = std::to_string(num % 7) + res;
            num /= 7;
        }
        res = std::to_string(num) + res;
        if(polar < 0){
            res = "-" + res;
        }
        return res;
    }
};