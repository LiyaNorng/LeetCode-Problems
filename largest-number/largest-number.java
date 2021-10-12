class Solution {
    
    class Largest implements Comparator<String>{
        
        @Override 
        public int compare(String a, String b){
            String x = a + b;
            String y = b + a;
            return y.compareTo(x);
        }
    }
    
    public String largestNumber(int[] nums) {
        
        String res = "";
        String [] temp = new String[nums.length];
        int k = 0;
        for (int i : nums){
            temp[k++] = String.valueOf(i);
        }
        
        Arrays.sort(temp, new Largest());
        if (temp[0].equals("0")){
            return "0";
        }
        for(String i : temp){
            res += i;
        }
        
        return res;
    
    }
}