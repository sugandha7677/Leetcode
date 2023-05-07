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
    public int kthSmallest(TreeNode root, int k) {
        // TreeNode node = root;
        // int count=0;
        // Stack<TreeNode> st = new Stack<>();
        // while(true){
        //     if(node != null){
        //         st.push(node);
        //         node = node.left;
        //     }else{
        //         if(st.isEmpty()) break;
        //         node = st.pop();
        //         count++;
        //         if(count == k){
        //             return node.val;
        //         }
        //         node = node.right;
        //     }
        // }
        // return -1;
        
        // using morris traversal
        TreeNode curr = root;
        int count = 0;
        
        while(curr != null) {
            if(curr.left == null){
                count++;
                if(count == k) return curr.val;
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) prev = prev.right;
                
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    count++;
                    if(count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }
        
        return -1;
    }
}