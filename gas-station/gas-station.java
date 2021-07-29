class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int totalSum = 0;
        int sum = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            sum = 0;
            for(int j = i ; j <= gas.length * 2; j++){
                sum += gas[j % n] - cost[j % n];
                if(sum < 0){
                    break;
                }
            }
            if(sum >= 0){
                return i;
            }
        }
        
        
        return -1;
        
        
    }
}