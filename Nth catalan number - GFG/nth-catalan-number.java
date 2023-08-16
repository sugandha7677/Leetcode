//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findCatalan(int n) {
        // code here
        
        if( n == 0 || n == 1) return n;
        
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            
            for(int j = i -1; j >= 0 ; j--){
                dp[i] += ((long) dp[j] * dp[i - j -1]) % (int)(1e9 + 7);
                dp[i] %= (int)(1e9 + 7);
            }
        }
        return dp[n];
        
    }
}
        
