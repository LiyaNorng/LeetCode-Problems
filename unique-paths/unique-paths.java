class Solution {
    public int uniquePaths(int m, int n) {
        return topDown(0, 0, m, n, new HashMap<>());
    }
    
    public int topDown(int m, int n, int M, int N, HashMap<Pair, Integer> hash){
        if(m >= M || n >= N){
            return 0;
        }
        
        if(m == M - 1 && n == N - 1){
            return 1;
        }
        
        Pair<Integer, Integer> pair = new Pair<>(m, n);
        if(hash.containsKey(pair)){
            return hash.get(pair);
        }
        int k = topDown(m + 1, n, M, N, hash) + topDown(m, n + 1, M, N, hash);
        hash.put(pair, k);
        return hash.get(pair);
    
}
}