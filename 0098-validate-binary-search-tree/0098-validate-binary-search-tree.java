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
    public boolean isValidBST(TreeNode root) {
    
        
        return check(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean check (TreeNode root, long lo, long hi){
        if(root ==  null) return true;
        
        if(root.val <= lo || root.val >= hi ) return false;
         
        return check(root.left, lo, root.val) && check(root.right, root.val, hi);
        
        
    }
    
}