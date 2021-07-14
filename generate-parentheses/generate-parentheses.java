class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        paren(n , 0, 0, list, new char [2 * n], 0);
        return list;
    }
    
    public void paren(int n, int open, int close, List<String> list, char [] s,int pos){
        
        if(n == close){
            list.add(new String (s));
            return ;
        }
        else{
            if(open > close){
                s[pos] = ')';
                paren(n, open, close + 1, list , s, pos + 1);
            }
            
            if(open < n){
                s[pos] = '(';
                paren(n, open + 1, close, list , s, pos + 1);
            }
        }
    }
}