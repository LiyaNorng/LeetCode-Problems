class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        return haystack.indexOf(needle);
       
        /**int i = 0;
        while(i < haystack.length()){
            i = haystack.indexOf(needle.charAt(0)); 
        }
        **/
    }
}