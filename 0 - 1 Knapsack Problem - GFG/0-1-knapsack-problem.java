//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         
         int [][] dp = new int [n][W + 1];
         
         for(int [] d : dp ){
             Arrays.fill(d, Integer.MIN_VALUE);
         }
         
         return f(0, W , wt, val, dp);
         
         
         
    }
    
    
    static int f(int idx , int w, int wt[] , int [] val, int [][] dp){
        
        if(idx >= wt.length) return 0;
        
        if(wt[idx] > w) return f(idx + 1, w, wt, val, dp);
        
        if(dp[idx][w] != Integer.MIN_VALUE) return dp[idx][w];
        
        
        int pick = val[idx] + f(idx + 1, w - wt[idx], wt, val, dp);
        
        int notpick = f(idx + 1, w , wt, val, dp);
        
        return dp[idx][w] = Math.max(pick, notpick);
    }
}


