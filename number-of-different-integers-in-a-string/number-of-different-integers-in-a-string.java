class Solution {
    public int numDifferentIntegers(String word) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < word.length(); i++){
            
            if(Character.isDigit(word.charAt(i))){
                int j = i;
                String temp = "";
                while(j < word.length() && Character.isDigit(word.charAt(j))){
                    if(temp.equals("") && word.charAt(j) == '0'){
                        j++;
                        continue;
                    }
                    temp += Character.toString(word.charAt(j));
                    j++;
                }
                i = j;
                set.add(temp);
            }
        }
        
        return set.size();
    }
}