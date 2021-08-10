class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newString = new String(c);
            if(map.containsKey(newString)){
                res.get(map.get(newString)).add(s);
            }
            else{
                res.add(new LinkedList<>());
                res.get(res.size() - 1).add(s);
                map.put(newString, res.size() - 1);
            }
        }
        
        return res;
    }
}