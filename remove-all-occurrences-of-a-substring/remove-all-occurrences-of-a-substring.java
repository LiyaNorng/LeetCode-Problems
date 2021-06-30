class Solution {
    public String removeOccurrences(String s, String part) {
        
        if(part.length() == 0 || s.length() == 0){
            return s;
        }
        
        List<Character> list = new LinkedList<>();
        int p = part.length();
        
        for(char c : s.toCharArray()){
            
            if(list.size() == 0 && part.length() == 1 && c != part.charAt(0)){
                list.add(c);
            }
            else{
                if(list.size() + 1 >= p && c == part.charAt(p - 1)){
                    int n = list.size() - 1;
                    int j = p - 2;
                    while(n >= 0 && j >= 0 && list.get(n) == part.charAt(j)){
                        n--;
                        j--;
                        
                    }
                    if(j == -1){
                        j = list.size() - 1;
                        while(j > n){
                            list.remove(j--);
                        }
                    }
                    else{
                        list.add(c);
                    }
                }
                else{
                    list.add(c);
                }
            }
        }
        
        s = "";
        
        for(int i = 0; i < list.size(); i++){
            s += Character.toString(list.get(i));
        }
        return s;  
    }
}