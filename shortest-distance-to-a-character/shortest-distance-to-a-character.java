class Solution {
    public int[] shortestToChar(String S, char C) {
        
        int[] ans = new int[S.length()];
        
        int prev = S.indexOf(C);
        
        for(int i = 0; i < ans.length; i++){
            if(S.charAt(i) == C){
                prev = i;
            }
            ans[i] = Math.abs(i - prev);
        }
        
        for(int i = ans.length - 1; i >= 0; i--){
            if(S.charAt(i) == C){
                prev = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(i - prev));
        }
        return ans;
        
        /**
        List<Integer> list = new LinkedList<>();
        int i = 0;
        for(char c : S.toCharArray()){
            if(c == C){
                list.add(i);
            }
            i++;
        }
        
        int min = 0;
        for(i = 0; i < ans.length; i++){
            if(S.charAt(i) == C){
                ans[i] = 0;
                continue;
            }
            min = Integer.MAX_VALUE;
            for(int j : list){
                min = Math.min(min, Math.abs(i - j));
            }
            ans[i] = min;
        }
        return ans;
        **/
    }
}