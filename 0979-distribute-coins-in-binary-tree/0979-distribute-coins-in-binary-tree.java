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
    int count = 0;
    public int distributeCoins(TreeNode root) {
        
        helper(root, root);
        return count;
    }
    
    void helper(TreeNode curr, TreeNode parent){
        if(curr == null) return;
        
        helper(curr.left, curr);
        helper(curr.right, curr);
        
        if(curr.val > 1){
            int extra = curr.val - 1;
            parent.val += extra;
            count += extra;
            curr.val = 1;
        }
        
        else if(curr.val < 1){
            int needed = 1 + Math.abs(curr.val);
            count += needed;
            parent.val -= needed;
            curr.val = 1;
        }
    }
}