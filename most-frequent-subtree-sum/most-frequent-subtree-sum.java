/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
    
        max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        helper(root, map, list);
        
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public int helper(TreeNode root, HashMap<Integer, Integer> map, LinkedList<Integer> list){
  
        int sum = 0;
        if(root.left != null){
            sum += helper(root.left, map, list);
        }
        if(root.right != null){
            sum += helper(root.right, map, list);
        }
        
        sum += root.val;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        if(map.get(sum) > max){
            list.clear();
            list.add(sum);
            max = map.get(sum);
        }
        else if(map.get(sum) == max){
            list.add(sum);
        }
        return sum;
    }
    
}