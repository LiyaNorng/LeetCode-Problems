class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> list = new LinkedList<>();
        int block = 0;
        String string = "";
        for(String s : source){
            for(int i = 0; i < s.length(); i++){
                
                if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '/' && block == 0){
                    if(string.length() > 0){
                        list.add(string);                        
                    }
                    string = "";
                    break;
                }
                else if(i + 3 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*' && s.charAt(i + 2) == '*' && s.charAt(i + 3) == '/' && block > 0){
                    //System.out.println("got here");
                    block--;
                    i += 3;
                }
                else if(i + 2 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*' && s.charAt(i + 2) == '/' && block == 0){
                    block++;
                    i += 2;
                }
                else if(i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*' && block == 0){
                    block++;
                    i++;
                }
                else if(i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/' && block > 0){
                    block--;
                    i++;
                }
                else{
                    if(block != 0){
                        continue;
                    }
                    string += Character.toString(s.charAt(i));
                }
            }
                
            //System.out.println(block + "   " + string.length());
            if(block == 0 && string.length() > 0){
                list.add(string);
                string = "";
            }
                         
        }
        return list;
    }
}


// ["struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"]














