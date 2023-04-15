/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        // deep copy
        Node curr = head;
        while(curr != null){
            Node node = new Node(curr.val);
            
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }
        
        // random pointer
        curr = head;
        while(curr != null){
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
            
        }
        
        // remove original one
        Node dummy = new Node(0);
        
        curr = head;
        Node temp = dummy;
        Node fast;
        
        while(curr != null){
            fast = curr.next.next;
            temp.next = curr.next;
            curr.next = fast;
            temp = temp.next;
            curr = fast;

        }
        return dummy.next;
    
    }
    
    // TC: O(n) + O(n) + O(n) = O(n)
    // SC: O(1)
}