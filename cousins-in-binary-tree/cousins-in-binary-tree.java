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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null){
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            
            root = queue.poll();
            if (root == null){
                if (queue.peek() != null){
                    queue.add(null);
                }
                for(int i : list){
                    if (i == y || i == x){
                        count++;
                    }
                }
                if (count == 1){
                    return false;
                }
                count = 0;
                list = new ArrayList<>();
            }
            else{
                list.add(root.val);
                if (root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
                if (root.left != null && root.right != null){
                    if(x == root.left.val && y == root.right.val || y == root.left.val && x == root.right.val){
                        return false;
                    }
                }
            }
        } 
        return true;
    }
    
}