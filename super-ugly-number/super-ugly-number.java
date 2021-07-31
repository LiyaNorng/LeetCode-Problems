class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        
        HashSet<Long> set = new HashSet<>();
        queue.add((long)1);
        set.add((long)1);
        Long num = (long)0;
        Long cur = (long)0;
        while( n > 0){
            num = queue.poll();
            if(n == 1){
                return num.intValue();
            }
            for(int i : primes){
                cur = num * i;
                if(set.contains(cur)){
                    continue;
                }
                queue.add(cur);
                set.add(cur);
            }
            n--;
        }
        return num.intValue();
    }
}