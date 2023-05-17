class Solution {
    
    public int fib(int n) {
       
        int [] dp = new int [n + 1];
        Arrays.fill(dp , Integer.MIN_VALUE);
        return f(n , dp);
    }
    
    int f(int n, int [] dp){
        if(n == 0 || n == 1) return n;
        
        if(dp[n] != Integer.MIN_VALUE) return dp[n];
        
        dp[n] = f(n-1 , dp) + f(n -2 , dp);
        return dp[n];
    }
}