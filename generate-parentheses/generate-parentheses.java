class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        
        helper(n, 0, 0, new char[n * 2], 0, res);
        return res;
  
    }
    
    public void helper(int n, int open, int close, char[] s, int p, List<String> res){
        
        if(close == n){
            res.add(new String(s));
            return;
        }
        else{
            
            if(open > close){
                s[p] = ')';
                helper(n, open, close + 1, s, p + 1, res);
            }
            if(open < n){
                s[p] = '(';
                helper(n, open + 1, close, s, p + 1, res);
            }
            
        }
        
    }
}