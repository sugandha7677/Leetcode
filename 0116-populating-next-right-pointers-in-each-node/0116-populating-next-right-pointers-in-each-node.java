/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = new Node(0);
            Node temp = prev;
            while(size-- > 0){
                Node node = q.poll();
                if(prev != null) temp.next = node;
                temp = temp.next;
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);   
            }
            temp.next = null;
            prev = null;
        }
        
        return root;
    }
}