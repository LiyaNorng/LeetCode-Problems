class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> list = new ArrayList<>();
        
        int[] p = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            p[s.charAt(i) - 'a'] = i;
        }
        
        
        int b = 0;
        int end = 0;
        int count = 0;
        
        while(b < s.length()){
            count = 0;    
            end = p[s.charAt(b) - 'a'];
            while(b < s.length() && b <= end){
                if(p[s.charAt(b) - 'a'] > end){
                    end = p[s.charAt(b) - 'a'];
                }
                b++;
                count++;
            }
            
            list.add(count);
        }
        
        return list;
        
        
    }
}