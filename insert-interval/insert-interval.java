class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int[] i : intervals){
            if(map.containsKey(i[0])){
                int max = Math.max(map.get(i[0]), i[1]);
                map.put(i[0], max);
                continue;
            }
            map.put(i[0], i[1]);
            queue.add(i[0]);
        }
        
        if(map.containsKey(newInterval[0])){
            int max = Math.max(map.get(newInterval[0]), newInterval[1]);
            map.put(newInterval[0], max);
        }
        else{
            map.put(newInterval[0], newInterval[1]);
            queue.add(newInterval[0]);
        }
  
        while(!queue.isEmpty()){
            int key = queue.poll();
            while(!queue.isEmpty() && map.get(key) >= queue.peek()){
                int max = Math.max(map.get(key), map.get(queue.peek()));
                map.remove(key);
                map.remove(queue.poll());
                map.put(key, max);
                //System.out.println("got");
            }
        }
        
        for(int i : map.keySet()){
            queue.add(i);
        }
        
        int[][] res = new int[map.size()][2];
        int k = 0;
        while(!queue.isEmpty()){
            res[k][0] = queue.peek();
            res[k++][1] = map.get(queue.poll());
        }
        return res;
    }
}