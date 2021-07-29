class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int totalSum = 0;
        int sum = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            totalSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                index = i + 1;
            }
        }
        
        
        return totalSum < 0? -1 : index;
        
        
    }
}