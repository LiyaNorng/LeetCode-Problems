class Solution {
    public String reorganizeString(String S) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        
        char[] string = new char[S.length()];
        int i = 0;
        while(!queue.isEmpty()){
            char c = queue.poll();
            int count = map.get(c);
            while(count-- > 0){
                string[i] = c;
                if(i - 1 >= 0 && string[i - 1] == string[i] ){
                    return "";
                }
                i += 2;
                if(i >= S.length()){
                    i = 1;
                }
            }
        }
        
        return new String(string); 
    }
}