class Solution {
    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int[] value = { 1, 5, 10, 50, 100, 500, 1000};
        char[] symbol = {'I', 'V', 'X', 'L','C', 'D', 'M'};
        
        for(int i = 0; i < value.length; i++){
            map.put(symbol[i], value[i]);
        }
        
        char prev = ' ';
        int ans = 0;
        for(char c : s.toCharArray()){
            if(prev != ' ' && map.get(prev) < map.get(c)){
                ans = ans - (2 * map.get(prev));
                prev = c;
                ans += map.get(c);
            }
            else{
                ans += map.get(c);
                prev = c;
            }
        }
        return ans;
    }
}