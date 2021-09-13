class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> num = new LinkedList<>();
        List<Integer> list = new LinkedList<Integer>();
        if(numRows == 0){
            return num;
        }
        if(numRows == 1){
            list.add(1);
            num.add(list);
            return num;
        }
        if(numRows == 2){
            list.add(1);
            num.add(list);
            list = new LinkedList<>();
            list.add(1);
            list.add(1);
            num.add(list);
            return num;
        }
        list.add(1);
        num.add(list);
        list = new LinkedList<>();
        list.add(1);
        list.add(1);
        num.add(list);
        int left = 0;
        int right = 1;
        for(int i = 2; i < numRows; i++){
            list = new LinkedList<>();
            
            left = 0;
            right = 1;
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    list.add(1);
                }
                else if(j == i){
                    list.add(1);
                    num.add(list);
                }
                else{
                    if(i == 2){
                        list.add(num.get(i - 1).get(left) + num.get(i - 1).get(right));
                    }
                    else{
                        //System.out.println(left + "  " + right + "  " + num.get(i - 1).get(left));
                        list.add(num.get(i - 1).get(left) + num.get(i - 1).get(right));
                        left++;
                        right++;
                    }
                }
            }
        }
        return num;
    }
}