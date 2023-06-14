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
    int min = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        
        inorder(root);
        
        return min;
    }
    
    void inorder(TreeNode node){
        
        if(node == null) return;
        
        inorder(node.left);
        
        if(prev != null){
            min = Math.min(min, node.val - prev.val);
        }
        
        prev = node;
        inorder(node.right);
        
        
    }
}