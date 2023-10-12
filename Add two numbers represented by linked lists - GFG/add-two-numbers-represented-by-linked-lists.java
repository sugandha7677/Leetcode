//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        if(first == null && second == null ) return new Node(0);
        
        first = reverseLL(first);
       second = reverseLL(second);
       
       int carry = 0;
       
       Node result = null;
       Node prev = null;
       
       while(first != null || second != null || carry > 0){
           int val1 = 0;
           if(first != null){
               val1 = first.data;
               first = first.next;
           }
           
           int val2 = 0;
           if(second != null){
               val2 = second.data;
               second = second.next;
           }
           
           int sum = val1 + val2+ carry;
           carry = sum / 10;
           sum = sum % 10;
           
           Node curr = new Node(sum);
           if(result == null) result = curr;
           else {
            prev.next= curr;
           }
           
           prev = curr;
       }
       
       
       
       result = reverseLL(result);
       return result;
       
    }
    
    static Node reverseLL(Node node){
        //if(node == null) return;
        
        Node prev = null;
        
        Node curr = node;
        
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            
            curr = temp;
        }
        
        return prev;
    }
}