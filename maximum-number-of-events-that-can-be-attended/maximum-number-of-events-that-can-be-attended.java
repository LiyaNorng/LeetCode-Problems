class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> {
            
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            
            return a[0] - b[0];
            
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);
        
        int i = 0;
        int d = 1;
        int n = events.length;
        int res = 0;
        while(i < n || !pq.isEmpty()){
            
            while(!pq.isEmpty() && pq.peek() < d){
                pq.poll();
            }
            
            while(i < n && events[i][0] == d){
                pq.offer(events[i++][1]);
            }
            
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
            d++;
        }        
        
        return res;
    }
}