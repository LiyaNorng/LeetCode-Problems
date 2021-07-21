class Solution {
    
    
    public int[][] kClosest(int[][] points, int k) {
        
        if(k == points.length){
            return points;
        }
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        for(int[] p : points){
            int dist = (int)(Math.pow(p[0], 2) + Math.pow(p[1], 2)); 
            queue.add(dist);
            if(queue.size() > k){
                queue.poll();
            }
            if(!map.containsKey(dist)){
                map.put(dist, new ArrayList<>());
            }
            map.get(dist).add(p);
        }
        
        int[][] res = new int[k][2];
        
        for(int i = 0; i < res.length; i++){
            int temp = queue.poll();
            int[] p = map.get(temp).remove(0);
            
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        return res;
    }
}