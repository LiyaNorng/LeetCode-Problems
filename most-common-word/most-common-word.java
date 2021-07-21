class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.trim();
        paragraph = paragraph.toLowerCase();
        String[] p = paragraph.split("[!?',;.\\s]+");
        
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> ban = new HashSet<>();
        for(String s : banned){
            ban.add(s);
        }
        
        int max = 0;
        String ans = "";
        for(String s : p){
            //System.out.println(s);
            if(!ban.contains(s)){
                map.put(s, map.getOrDefault(s, 0) + 1);
                if(max < map.get(s)){
                    ans = s;
                    max = map.get(s);
                }
            }
        }
        return ans;
    }
}