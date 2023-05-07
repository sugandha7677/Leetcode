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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        return f(root, k, map);
    }
    
    boolean f(TreeNode root, int k, HashMap<Integer, Integer> map){
        if(root == null) return false;
        
        if(map.containsKey(k - root.val)) return true;
        
        
            map.put(root.val , 0);
            return f(root.left, k , map) || f(root.right, k, map);
        
    }
}