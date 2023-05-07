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
    
    int idx = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {

        return createBST(preorder, Integer.MAX_VALUE );
        
    }
    
    TreeNode createBST(int [] preorder, int hi ){
        
        if (idx == preorder.length || preorder[idx] > hi) return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        
        root.left = createBST(preorder, root.val);
        root.right = createBST(preorder, hi );
        
        return root;
    }
    
}