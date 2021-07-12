class WordDictionary {

    
    private boolean isLeaf;
    private HashMap<Character, WordDictionary> children;
    
    
    
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        isLeaf = false;
        children = new HashMap<>();
    }
    
    
    public void addWord(String word) {
        WordDictionary dict = this;
        
        for(char c : word.toCharArray()){
            dict.children.putIfAbsent(c, new WordDictionary());
            dict = dict.children.get(c);
        }
        dict.isLeaf = true;
    }
    
    public boolean search(String word) {
        return searchWord(this, 0,  word);
    }
    
    public boolean searchWord(WordDictionary dict, int k,  String word){
        if(k >= word.length() && dict == null){
            return false;
        }
        
        for(int i = k; i < word.length(); i++){
            
            if(word.charAt(i) == '.'){
                for(char a = 'a'; a <= 'z'; a++){
                    if(dict.children.containsKey(a) && searchWord(dict.children.get(a), i + 1, word)){
                        return true;
                    }
                }
                return false;
                
            }
            dict = dict.children.get(word.charAt(i));
            if(dict == null){
                return false;
            }
        }
        return dict.isLeaf;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */