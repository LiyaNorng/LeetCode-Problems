class Solution {
    public String reverseWords(String s) {
        
        boolean frontSpace = false, endSpace = false;
        String buffer = "";
        String newString = "";
        for(int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) != ' '){
                while(i < s.length() && s.charAt(i) != ' '){
                    buffer += s.charAt(i);
                    i++;
                }
                
                newString = buffer + " " + newString;
                buffer = "";
            }
        }
        return newString.trim();      
    }
}