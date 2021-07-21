class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        if (words.length == 0 || words == null){
            return new ArrayList<>();
        }
        
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> 
        map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));                                                 
                                                 
                                                 
        for(String i : words){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(String i : map.keySet()){
            heap.add(i);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        while(!heap.isEmpty()){
            res.add(0, heap.poll());
        }
        //Collections.reverse(res);
        return res;
    }
}