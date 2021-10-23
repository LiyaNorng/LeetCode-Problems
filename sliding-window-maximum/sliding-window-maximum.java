class Solution {
 
     public int[] maxSlidingWindow(int[] nums, int k) {
        
        int [] res = new int [nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
         
         for(int i = 0; i < nums.length; i++){
             
             if(!list.isEmpty() && list.peek() == i - k){
                 list.removeFirst();
             }
             while(!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                 list.removeLast();
             }
             
             list.add(i);
             
             if(i + 1 >= k){
                 res[i + 1 - k] = nums[list.peekFirst()];
             }
         }         
        return res;
    }
    
    
    /**
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int [] res = new int [nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int t = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> a == b? a-b : b-a);
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
            list.addLast(nums[i]);
        }
        res[t++] = queue.peek();
        int rem = list.removeFirst();
        queue.remove(rem);
        for (int i = k ; i < nums.length ; i++){
            queue.add(nums[i]);
            list.addLast(nums[i]);
            if(queue.size() == k){
                res[t++] = queue.peek();
                rem = list.removeFirst();
                queue.remove(rem);
            }
        }
        return res;
    }
    
    **/
}