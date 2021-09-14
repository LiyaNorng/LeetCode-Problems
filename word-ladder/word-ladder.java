class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)){
            return 0;
        }
        
        Queue<Pair<String, Integer>> queueOne = new LinkedList<>();
        Queue<Pair<String, Integer>> queueSecond = new LinkedList<>();
        
        HashMap<String, Integer> visitedOne = new HashMap<>();
        HashMap<String, Integer> visitedSecond = new HashMap<>();
        
        HashMap<String, List<String>> dict = new HashMap<>();
        
        wordList.forEach(word -> {
            
            for(int i = 0; i < beginWord.length(); i++){
                String newWord = word.substring(0, i) +'#'+ word.substring(i + 1, beginWord.length());
            
            List<String> transform = dict.getOrDefault(newWord, new ArrayList<>());
            transform.add(word);
            dict.put(newWord, transform);   
            }
        });
        
        
        queueOne.add(new Pair<>(beginWord, 1));
        visitedOne.put(beginWord, 1);
        queueSecond.add(new Pair<>(endWord, 1));
        visitedSecond.put(endWord, 1);
        int res = 0;
        while(!queueOne.isEmpty() && !queueSecond.isEmpty()){
            res = BFS(dict, visitedOne, visitedSecond, queueOne);
            if(res > -1){
                return res;
            }
            res = BFS(dict, visitedSecond, visitedOne, queueSecond);
            if(res > -1){
                return res;
            }
        }
        return 0;
    }
    
    
    public int BFS(HashMap<String, List<String>> dic, HashMap<String, Integer> visitedOne, HashMap<String, Integer> visitedSecond, Queue<Pair<String, Integer>> queue){
        
        Pair pair = queue.poll();
        String temp = (String)pair.getKey();
        int value = (int)pair.getValue();
        
        for(int i = 0; i < temp.length(); i++){
            String cur = temp.substring(0, i) + '#' + temp.substring(i + 1, temp.length());
            for(String adj : dic.getOrDefault(cur, new ArrayList<>())){
                
                if(visitedSecond.containsKey(adj)){
                    return visitedSecond.get(adj) + value;
                }
                
                if(!visitedOne.containsKey(adj)){
                    visitedOne.put(adj, value + 1);
                    queue.add(new Pair<>(adj, value + 1));
                }
            }
        }
        return -1;  
    }   
}