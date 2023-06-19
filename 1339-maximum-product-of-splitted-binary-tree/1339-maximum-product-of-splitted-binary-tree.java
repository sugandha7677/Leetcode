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
    long max = 0;
    long totalSum = 0;
    public int maxProduct(TreeNode root) {
        totalSum = f(root);
        //System.out.println(totalSum);
        f(root);
        return (int) (max % (int)(1e9 + 7));
    }
    
    int f(TreeNode root){
        if(root == null) return 0;
        
        int lsum = f(root.left);
        int rsum = f(root.right);
        
        int currSum = lsum + rsum + root.val;
        
        max = Math.max(max, (totalSum - currSum) * currSum);
        
        return currSum;
    }
}