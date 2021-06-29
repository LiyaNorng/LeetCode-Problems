class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        boolean sign = true;
        if(s.length() == 0){
            return 0;
        }
        if(s.charAt(0) == '-'){
            sign = false;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '+'){
            s = s.substring(1);
        }
        
        Long temp = (long)0;
        
        for(char c : s.toCharArray()){
            if(c == ' ' || !Character.isDigit(c) || temp >= Integer.MAX_VALUE || temp <= Integer.MIN_VALUE){
                break;
            }
            temp *= 10;
            temp += (int)(c - '0');
        }
        
        temp *= sign? 1 : -1;
        if(temp >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if (temp <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else{
            return temp.intValue();
        }
    }
}