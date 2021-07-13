class WordFilter {

    Trie pref;
    Trie suf;
    
    public WordFilter(String[] words) {
        pref = new Trie();
        suf = new Trie();
        for(int i = 0; i < words.length; i++){  
            pref.insert(words[i], i);
            suf.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }
    
    public int f(String prefix, String suffix) {
        
        List<Integer> p = pref.search(prefix);
        List<Integer> s = suf.search(new StringBuilder(suffix).reverse().toString());

        int i = p.size() - 1;
        int j = s.size() - 1;

        while(i >= 0 && j >= 0){
            if(p.get(i).equals(s.get(j))){
                return p.get(i);
            }
            else if(p.get(i) > s.get(j)){
                i--;
            }
            else{
                j--;
            }
        }
        
        return -1;
    }
}

class Trie{
        //private HashMap<Character, Trie> children;
        private Trie[]map;
        private List<Integer> list;
        
        public Trie(){
            //children = new HashMap<>();
            map = new Trie[26];
            list = new ArrayList<>();
        }
        
        public void insert(String word, int i){
            Trie root = this;
            for(char c : word.toCharArray()){
                //root.children.putIfAbsent(c, new Trie());
                //root = root.children.get(c);
                if(root.map[c - 'a'] == null){
                    root.map[c - 'a'] = new Trie();
                }
                root = root.map[c - 'a'];
                root.list.add(i);
            }
        }
        
        public List search(String word){
            Trie root = this;
            for(char c : word.toCharArray()){
                //root = root.children.get(c);
                root = root.map[c - 'a'];
                if(root == null){
                    return new ArrayList<>();
                }
            }
            return root.list;
        }
    }
    

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */