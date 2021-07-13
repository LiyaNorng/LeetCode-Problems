class Solution {
    public boolean isMonotonic(int[] A) {
        int incCount = 0;
        int decCount = 0;
        int eqCount = 0;
        for(int i = 1; i < A.length ; i++){
            if(A[i - 1] < A[i]){
                decCount++;
            }
            else if(A[i - 1] > A[i]){
                incCount++;
            }
            else{
                eqCount++;
            }
        }
        
        if(eqCount == A.length - 1 || decCount == A.length - 1 || incCount == A.length - 1 || eqCount + decCount == A.length - 1 || eqCount + incCount == A.length - 1){
            return true;
        }
        return false;
    }
}