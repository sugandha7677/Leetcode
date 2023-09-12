//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long N) {
        // code here
        
        long sum = 0;
        for(int i = 1; i < Math.sqrt(N); i++){
            
            if(N % i == 0) {
                
                sum += i;
                if( i != 1 && N / i != i)
                    sum += N/ i;
            }
        }
        
        if(sum == N) return 1;
        
        return 0;
    }
};