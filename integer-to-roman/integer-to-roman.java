class Solution {
    public String intToRoman(int num) {
                
        int[] value = { 1, 4, 5, 9,10,40, 50, 90, 100,400, 500, 900, 1000};
        String[] symbol = {"I","IV" , "V","IX", "X","XL" ,"L","XC", "C","CD", "D","CM", "M"};
        String res = "";
        for(int i = value.length - 1; i >= 0; i--){
            while(num >= value[i]){
                num -= value[i];
                res += symbol[i];
            }
        }
        return res;
    }
}