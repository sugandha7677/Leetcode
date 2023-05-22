class Solution {
    public int longestPalindromeSubseq(String s) {
        
        StringBuilder sb=new StringBuilder(s);  
        sb.reverse();  
        
        return longestCommonSubseq(s, sb.toString());
    }
    
    int longestCommonSubseq(String s1, String s2) {
        
        int n = s1.length() - 1;
        int m = s2.length() - 1;
        
        int [][]dp = new int[n + 1][m + 1];
        for(int [] d : dp) Arrays.fill(d, -1);
        
        return f(n , m , s1, s2, dp);
    }
    
    int f(int idx1, int idx2, String s1, String s2, int [][]dp){
        if(idx1 < 0 || idx2 < 0) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] =  1 + f(idx1 - 1, idx2 - 1, s1, s2, dp);
        }
        
        else{
            return dp[idx1][idx2] =  0 + Math.max(f(idx1 - 1, idx2, s1, s2, dp) , f(idx1, idx2 - 1, s1, s2, dp));
        }
    }
}
