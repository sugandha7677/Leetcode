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
    boolean find = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        findSum(root, targetSum, 0);
        return find;
    }
    void findSum(TreeNode root, int target, int sum){
        if(root == null) return;
       if(root.left == null && root.right == null){
           sum += root.val;
           if(sum == target)
                find = true;
            return;    
        }
        
        
        findSum(root.left, target, sum + root.val);
        findSum(root.right, target, sum + root.val);
    }
}