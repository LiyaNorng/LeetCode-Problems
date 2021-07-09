class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.contains("0") || digits.length() == 0){
            return new ArrayList<>();
        }
        HashMap<Integer, String> phone = new HashMap<>();
        
        phone.put(2, "abc");
        phone.put(3, "def");
        phone.put(4, "ghi");
        phone.put(5, "jkl");
        phone.put(6, "mno");
        phone.put(7, "pqrs");
        phone.put(8, "tuv");
        phone.put(9, "wxyz");
        List<String> res = new ArrayList<>();
        backTrack(phone, "", res, digits);   
        return res;
    }
    
    public void backTrack(HashMap<Integer, String> phone, String cur, List<String> res, String dig){
        
        if(0 == dig.length()){
            res.add(cur);
            return;
        }
        int key = Integer.valueOf(dig.substring(0, 1));
        String lett = phone.get(key);

        for(int i = 0; i < lett.length(); i++){
            String ch = lett.substring(i, i + 1);
            backTrack(phone, cur + ch, res, dig.substring(1));
        }   
    }
}