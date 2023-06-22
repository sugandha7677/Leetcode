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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        findPath(root, "");
        
        return sum;
    }
    
    void findPath(TreeNode root, String path){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            System.out.println(path);
            path = path + root.val+"";
            int num = Integer.parseInt(path);
            sum += num;
            return;
        }
        //System.out.println(path);
        findPath(root.left, path + root.val + "");
        findPath(root.right, path + root.val + "");
    }
    
}