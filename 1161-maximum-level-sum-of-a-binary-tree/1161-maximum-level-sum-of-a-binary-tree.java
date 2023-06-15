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
    int sum = Integer.MIN_VALUE;
    int level = 0;
    public int maxLevelSum(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(root, 1));
        
        while(!q.isEmpty()){
            int size = q.size();
            int lsum = 0;
            int l = q.peek().level;
            while(size-- > 0){
                pair p = q.poll();
                
                lsum += p.node.val;
                if(p.node.left != null){
                    q.add(new pair(p.node.left , p.level + 1));
                }
                
                if(p.node.right != null){
                    q.add(new pair(p.node.right, p.level + 1));
                }
            }
            
            if(lsum > sum ) {
                sum = lsum;
                level = l;
            }
        }
        
        return level;
    }
}

class pair{
    TreeNode node;
    int level;
    
    pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}