class Solution {
    public int secondHighest(String s) {
        
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) && !set.contains(Character.getNumericValue(c))){
                list.add(Character.getNumericValue(c));
                set.add(Character.getNumericValue(c));
            }
        }
        
        if(list.size() <= 1){
            return -1;
        }
        Collections.sort(list);
        
        return list.get(list.size() - 2);
        
    }
}