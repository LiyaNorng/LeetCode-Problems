class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        HashSet<String> set = new HashSet<>();
        
        for(String s : words){
            set.add(s);
        }
        
        List<String> list = new ArrayList<>();
        
        for(String s : words){
            if(concat(s, set)){
                list.add(s);
            }
        }
        return list;
    }
    
    public boolean concat(String s, HashSet<String> set){
        
        for(int i = 1; i < s.length();i++){
            String suffix = s.substring(i);
            String prefix = s.substring(0, i);
            if(set.contains(prefix) && (set.contains(suffix) || concat(suffix, set))){
                return true;
            }
        }
        return false;
    }
}