class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
    
        int prev = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String temp = Arrays.toString(cells);
            if(map.containsKey(temp)){
                int c = i - map.get(temp);
                c = (n - i) % c;
                return prisonAfterNDays(cells, c);
            }
            else{
                map.put(temp, i);
                prev = cells[0];
                int cur = 0;
                for(int j = 1; j < cells.length - 1; j++){
                    cur = cells[j];
                    cells[j] = prev + cells[j + 1] == 2 || prev + cells[j + 1] == 0 ? 1 : 0;
                    prev = cur;
                }
              
            }
            cells[0] = 0;
            cells[cells.length - 1] = 0;
        }
        return cells;
    }
}