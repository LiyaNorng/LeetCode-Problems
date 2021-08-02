class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        HashSet<List<Integer>> set = new HashSet<>();
        backTrack(set, new LinkedList<>(), target, 0, candidates, 0);
        return new ArrayList(set);
        
    }
    
    public void backTrack(HashSet<List<Integer>> set, List<Integer> list, int target, int sum, int[] num, int index){
        
        if(sum > target){
            return;
        }
        
        if(sum == target){
            set.add(new LinkedList(list));
            return;
        }
        
        for(int i = index; i < num.length; i++){
            sum += num[i];
            list.add(num[i]);
            backTrack(set, list, target, sum, num, i);
            sum -= num[i];
            list.remove(list.size() - 1);
        }
    }   
}