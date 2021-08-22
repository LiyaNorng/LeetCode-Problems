class Solution {
    public int lengthOfLastWord(String s) {
        String newString = s.trim();
        if (newString.length() == 0 || newString.isEmpty()){
            return 0;
        }
        int i;
        for (i = newString.length() - 1; i > 0; i--){
            if (newString.charAt(i) == ' '){
                i++;
                break;
            }
        }  
        return newString.substring(i).trim().length();   
    }
}