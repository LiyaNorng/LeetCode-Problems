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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if(root == null){
            return new ArrayList(new ArrayList<>());
        }
        
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            root = queue.poll();
            if (root == null){
                if (queue.peek() != null){
                    queue.add(null);
                }
                res.add(0,list);
                list = new ArrayList<>();
            }
            else{
                list.add(root.val);
                if (root.left != null){
                    queue.add(root.left);
                }
                if (root.right != null){
                    queue.add(root.right);
                }   
            }
        }

        return res;
    }
}