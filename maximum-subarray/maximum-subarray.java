class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Arrays.stream(nums).max().getAsInt();
        int m = 0;
        if (max < 0){
            return max;
        }
        for (int i : nums){
            m += i;
            m = Math.max(m, 0);
            //System.out.print(m + "  ");
            max = Math.max(max, m);
            //System.out.print(max + "   " ); 
        }
        return max;  
    }
}