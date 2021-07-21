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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null){
            return false;
        }
        else if(subTree(root, subRoot)){
            return true;
        }
        else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        
    }
    
    public boolean subTree(TreeNode root, TreeNode subRoot){
        if(root == null || subRoot == null){
            return root == null && subRoot == null;
        }
        
        if(root.val == subRoot.val){
            return subTree(root.left, subRoot.left) && subTree(root.right, subRoot.right);
        }
        else{
            return false;
        }
    }
}