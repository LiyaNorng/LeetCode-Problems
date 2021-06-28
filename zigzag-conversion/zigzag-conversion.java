class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows <= 1){
            return s;
        }
        
        List<String> list = new ArrayList<>();
        int min = Math.min(s.length(), numRows);
        for(int i = 0; i < min; i++){
            list.add("");
        }
        
        boolean dir = false;
        int k = 0;
        
        for(int i = 0; i < s.length(); i++){
            list.set(k, list.get(k) + s.substring(i, i + 1));
            if(k == 0 || k == numRows - 1){
                dir = !dir;
            }
            k += dir ? 1 : -1;
        }
        
        String ans = "";
        for(String c : list){
            ans += c;
        }
        return ans;
    }
}