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
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null){
            return new ArrayList<>();
        } 
        
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);        

        while(!queue.isEmpty()){
        
            root = queue.poll();
            if(root == null){
                if(queue.peek() != null){
                    queue.add(null);
                }
                res.add(stack.pop());
                stack = new Stack<>();
            }
            else{
                stack.push(root.val);
                if(root.left != null){
                    queue.add(root.left);
                }
                
                if(root.right != null){
                    queue.add(root.right);
                }
            }
        }
      
        return res;
    }

}