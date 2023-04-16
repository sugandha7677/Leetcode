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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val) head = head.next;
                
                
            }
            else{
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
            
        }
        
        
        prev.next = null;
        return dummy.next;
    }
}