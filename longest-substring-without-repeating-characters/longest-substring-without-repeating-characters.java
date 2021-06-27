class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 1){
            return length;
        }
        
        String longSubString = "";
        String tempString = "";
        for (int i = 0; i < length; i++){
            for (int j = i; j < length; j++){
                if (tempString.contains(Character.toString(s.charAt(j)))){
                    if (tempString.length() > longSubString.length()){
                        longSubString = tempString;
                    }
                    tempString = "";
                    break;
                }
                tempString = tempString + s.charAt(j); 
            }
        }    
        return longSubString.length();  
    }
}