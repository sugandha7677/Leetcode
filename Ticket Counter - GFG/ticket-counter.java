//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        
        if(K > N) return N;
        
        if(K == 1) return N / 2 + 1;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i = 1; i <= N; i++)
            q.add(i);
            
        
        while(!q.isEmpty()){
            
            for(int i = 0; i < K; i++){
                q.removeFirst();
                
                if(q.size() == 1) return q.peek();
            }
            
            for(int i = 0; i < K; i++){
                q.removeLast();
                
                if(q.size() == 1) return q.peek();
            }
        }
        
        return -1;
        
        
    }
}