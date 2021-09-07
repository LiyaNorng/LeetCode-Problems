class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        int carry = 0;
        int k = 1;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--){
            sum = digits[i] + k + carry;
            k = 0;
            if (sum > 9){
                sum -= 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            list.add(sum);
        }
        if (carry != 0){
            list.add(carry);
        }
        
        int [] res = new int [list.size()];
        k = 0;
        for (int i = list.size() - 1; i >= 0; i--){
            res[k++] = list.get(i);
        }
        return res;   
    }
}