class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(n == 0){
            return tasks.length;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        queue.addAll(map.values());
        LinkedList<Integer> list = new LinkedList<>();
        
        int time = 0;
        int res = 0;
        
        while(!queue.isEmpty()){
            
            time = 0;
            list = new LinkedList<>();
            
            for(int i = 0; i < n + 1; i++){
                if(!queue.isEmpty()){
                    time++;
                    list.add(queue.poll() - 1);
                }
            }
            
            for(int i : list){
                if(i > 0){
                    queue.add(i);
                }
            }
            
            res += queue.isEmpty() ? time : n + 1;
        }
        return res;
    }
}