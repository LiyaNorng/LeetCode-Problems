class Solution {
    public int maxPoints(int[][] points) {
        
        HashMap<Double, Integer> map = new HashMap<>();
        int max = 1;
        int runMax = 1;
        int same = 0;
        for(int i = 0; i < points.length; i++){
            map = new HashMap<>();
            same = 0;
            runMax = 1;
            for(int j = i + 1; j < points.length; j++){
                
                if(isSame(points[i][0], points[i][1], points[j][0], points[j][1])){
                    same++;
                    continue;
                }
                double slope = slope(points[i][0], points[i][1], points[j][0], points[j][1]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                runMax = Math.max(runMax, map.get(slope));
                //System.out.println(slope);
            }
            max = Math.max(max, runMax + same);
        }
        return max;
        
    }
    
    public boolean isSame(int x1, int y1, int x2, int y2){
        return x1 == x2 && y1 == y2;
    }
    
    public double slope(int x1, int y1, int x2, int y2){
        if(y1 == y2){
            return Integer.MAX_VALUE;
        }
        if(x1 == x2){
            return 0;
        }
        return (double)(y2 - y1) / (double)(x2 - x1);
    }

}