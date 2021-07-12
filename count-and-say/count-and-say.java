class Solution {
    public String countAndSay(int n) {
        
        if(n == 1){
            return "1";
        }
        
        String res = "1";
        
        while(n > 1){
            StringBuilder num = new StringBuilder();
            
            for(int i = 0; i < res.length(); i++){
                
                int count = 1;
                while(i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)){
                    i++;
                    count++;
                }
                 num.append(count).append(res.charAt(i));
            }
            res = num.toString();
            n--;
        }
        return res;
    }
}