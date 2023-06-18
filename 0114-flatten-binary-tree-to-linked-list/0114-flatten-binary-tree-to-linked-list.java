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
     Stack<TreeNode> st = new Stack<>();
    public void flatten(TreeNode root) {
      
        if(root == null) return;
        f(root);
        
        TreeNode head = new TreeNode(0);
        TreeNode prev = head;
        while(!st.isEmpty()){
            prev.right = st.pop();
            prev.left = null;
            prev = prev.right;
        }
        
       root = head.right;
    }
    
    
    void f(TreeNode root){
        if(root == null) return;
        
        f(root.right);
        f(root.left);
        st.add(root);
    }
}