class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, List<Integer>> mapS = new HashMap<>();
        HashMap<Character, List<Integer>> mapT = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(!mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i), new ArrayList<>());
            }
            if(!mapT.containsKey(t.charAt(i))){
                mapT.put(t.charAt(i), new ArrayList<>());
            }
            mapT.get(t.charAt(i)).add(i);
            mapS.get(s.charAt(i)).add(i);
        }
        
        if(mapS.size() != mapT.size()){
            return false;
        }
        
        for(int i = 0; i < mapS.size(); i++){
            if(!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}