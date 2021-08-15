class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(candidates);
        backTrack(list, new LinkedList<>(), candidates, target, 0, 0);
        return new ArrayList(list);
    }
    
    public void backTrack(Set<List<Integer>> list, List<Integer> num, int[]candi, int target, int sum, int index){
        
        if(sum == target){
            list.add(new LinkedList(num));
            return;
        }
        
        if(sum > target){
            return;
        }
        
        for(int i = index; i < candi.length; i++){
            if(sum > target){
                return;
            }
            if(i > index && candi[i] == candi[i - 1]){
                continue;
            }
            sum += candi[i];
            num.add(candi[i]);
            backTrack(list, num, candi, target, sum, i + 1);
            sum -= candi[i];
            num.remove(num.size()- 1);
        }
    } 
}