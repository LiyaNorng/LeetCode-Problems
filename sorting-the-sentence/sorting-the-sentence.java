class Solution {
    public String sortSentence(String s) {
        
        TreeMap<Integer, String> map = new TreeMap<>();
        
        String[] string = s.split(" ");
        
        for(String c : string){
            int temp = Integer.valueOf(c.substring(c.length() - 1));
            map.put(temp, c.substring(0, c.length() - 1));
        }
        
        s = "";
        for(int i : map.keySet()){
            s += map.get(i) + " ";
        }
        return s.substring(0, s.length() - 1);
    }
}