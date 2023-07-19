//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        
        
        int n = S.length();
        
        int [][] dp = new int [n][n];
        for(int [] d : dp){
            Arrays.fill(d, -1);
        }
        
        return lps(S, 0, n - 1, dp);
    }
    
    int lps(String S, int i , int j, int [][] dp){
        
        if(i == j) return dp[i][j] = 1;
        
        if(S.charAt(i) == S.charAt(j) && i + 1 == j){
            dp[i][j] = 2;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(S.charAt(i) == S.charAt(j)){
            return dp[i][j] = lps(S, i + 1, j -1, dp) + 2;
        }
        
        return dp[i][j] = Math.max(lps(S, i + 1, j, dp), lps(S, i, j -1, dp));
    }
}