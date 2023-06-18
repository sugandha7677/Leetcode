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
    int inordersum = 0;
    public TreeNode convertBST(TreeNode root) {
         f(root);
        return root;
    }
    
    void f(TreeNode root){
        if(root == null) return;
        
       
        
        f(root.right);
        root.val += inordersum;
        inordersum = root.val;
        f(root.left);
        
    }
}