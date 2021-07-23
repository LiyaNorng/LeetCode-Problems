class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> res = new ArrayList<>();
        int[] lowest = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n ;i++){
            graph[i] = new ArrayList<>();
            lowest[i] = -1;
        }
        
        for(List<Integer> list : connections){
            graph[list.get(0)].add(list.get(1));
            graph[list.get(1)].add(list.get(0));
        }
        DFS(lowest, 0, 0, -1, graph, res);
        return res;
    }
    
    public int DFS(int[] lowest, int level, int v, int parent, List<Integer>[] graph, List<List<Integer>> res){
        
        lowest[v] = level + 1;
        
        for(int child : graph[v]){
            if(child == parent){
                continue;
            }
            else if(lowest[child] == -1){
                lowest[v] = Math.min(lowest[v], DFS(lowest, level + 1, child, v, graph, res));
            }
            else{
                lowest[v] = Math.min(lowest[v], lowest[child]);
            }
        }
        
        if(lowest[v] == level + 1 && v != 0){
            List<Integer> cur = new ArrayList<>();
            cur.add(parent);
            cur.add(v);
            res.add(cur);
        }
        return lowest[v];
    }
}