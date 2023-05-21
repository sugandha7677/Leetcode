class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int [][] dp = new int [text1.length()][text2.length()];
        
        for(int [] d: dp)
            Arrays.fill(d, Integer.MIN_VALUE);
        
        return f(text1.length() - 1, text2.length() - 1, text1, text2, dp);
    }
    
    int f(int idx1, int idx2, String s1, String s2, int [][]dp){
        
        if(idx1 < 0 || idx2 < 0) return 0;
        
        if(dp[idx1][idx2] != Integer.MIN_VALUE) return dp[idx1][idx2];
        
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + f(idx1 - 1, idx2 - 1, s1, s2, dp);
        }
        else{
            return dp[idx1][idx2] = 0 + Math.max(f(idx1 - 1, idx2, s1, s2, dp), f(idx1, idx2 - 1, s1, s2, dp));
        }
    }
}