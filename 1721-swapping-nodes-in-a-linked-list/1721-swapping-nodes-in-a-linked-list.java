/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        int c = 1;
        while(c++ < k ){
            fast = fast.next;
        }
        
        ListNode start = fast;
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode end = slow;
        
        // swap
        int temp = start.val;
        start.val = end.val;
        end.val = temp;
        
        
        return head;
    }
    
}

// TC: O(n)
// SC: O(n)
