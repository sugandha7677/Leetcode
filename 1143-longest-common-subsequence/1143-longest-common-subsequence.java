class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int [][] dp = new int [text1.length() + 1][text2.length() + 1];
        
        
        for(int i = 0; i < dp.length; i++) dp[i][0] = 0;
        
        for(int j = 0; j < dp[0].length; j++) dp[0][j] = 0;
        
        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i -1][j -1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
        
        //return f(text1.length() - 1, text2.length() - 1, text1, text2, dp);
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