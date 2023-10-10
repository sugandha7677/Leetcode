//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root == null) return list;
        
       
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node targetNode = null;
        
        Queue<Node> q = new LinkedList();
        q.add(root);
        //map.put(root, -1);
        
        while(!q.isEmpty()){
            
            Node node = q.poll();
            
            if(node.data == target)
                targetNode = node;
            
            
            if(node.left != null){
                map.put(node.left, node);
                q.add(node.left);
            }
            
            if(node.right != null){
                map.put(node.right, node);
                q.add(node.right);
            }
        }
        
        // map to store occurance and traverse in all 3 direction
        HashMap<Node, Integer> mapIndex = new HashMap<>();
        q.add(targetNode);
        
        int level = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size-- > 0){
                Node temp = q.poll();
                
                mapIndex.put(temp, 1); // node is taken
                if(level == k){
                    list.add(temp.data);
                }
                
                if(temp.left != null && mapIndex.getOrDefault(temp.left, 0) == 0)
                    q.add(temp.left);
                    
                if(temp.right != null && mapIndex.getOrDefault(temp.right, 0) == 0)
                    q.add(temp.right);
                    
                
                if(map.containsKey(temp) && mapIndex.getOrDefault(map.get(temp) , 0) == 0)
                    q.offer(map.get(temp));
                    
            }
            
            level++;
            if(level > k)
                break;
        }
        
        
        Collections.sort(list);
        return list;
    }
    
};