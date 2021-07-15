class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> dict = new HashMap<>();
        for(String c : words){
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        int len = words[0].length() * words.length;
        int j = 0;
        int index = 0;
        String cur = "";
        for(int i = 0; i <= s.length() - len; i++){
            
            index = 0;
            j = 0;
            map = new HashMap<>();
            cur = s.substring(i, i + len);
            while(index < words.length){
                String part = cur.substring(j, j + words[0].length());
                map.put(part, map.getOrDefault(part, 0) + 1);
                j += words[0].length();
                index++;
            }
            
            if(map.equals(dict)){
                list.add(i);
            }
        }
        return list;
    }
}