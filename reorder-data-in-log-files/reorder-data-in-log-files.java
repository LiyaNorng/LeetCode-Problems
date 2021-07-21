class Solution {
    public String[] reorderLogFiles(String[] logs) {
    
        int numCount = 0;
        
        for (int i = logs.length - 1; i >= 0; i--){
            if(Character.isDigit(logs[i].charAt(logs[i].length() - 1))){
                //System.out.println(logs[i].charAt(logs[i].length() - 1));
                String temp = logs[i];
                logs[i] = logs[logs.length - 1 - numCount];
                logs[logs.length - 1 - numCount] = temp;
                numCount++;
            }
        }
        
        Arrays.sort(logs, 0, logs.length - numCount,(a,b)->{
            String a1 = a.substring(a.indexOf(" ")+1);
            String b1 = b.substring(b.indexOf(" ")+1);
            int i = a1.compareTo(b1);
            if(i!=0) return i;
            else return a.compareTo(b);
        });
        
        return logs;
    }
}