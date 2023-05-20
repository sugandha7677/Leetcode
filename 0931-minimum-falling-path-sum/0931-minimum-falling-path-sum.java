class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int [][]dp = new int[m][n];
        for(int i = 0; i < n; i++) dp[0][i] = matrix[0][i];
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                // 0th col have no col - 1
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                // last col have no col + 1
                else if (j == n - 1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j+1],
                                                                     dp[i-1][j-1] ));
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++){
            ans = Math.min(ans, dp[m-1][col]);
        }
        return ans;
        
    }

    
    int f(int col, int row, int [][]matrix , int [][]dp){
        if(col < 0 || row < 0 || col >= matrix.length || row >= matrix[0].length)
            return Integer.MAX_VALUE;
        
        if(col == matrix.length - 1) return matrix[col][row];
        
        if(dp[col][row] != Integer.MAX_VALUE) return dp[col][row];
        
        return dp[col][row] = matrix[col][row] + Math.min(f(col+1, row - 1, matrix, dp), Math.min(f(col + 1, row , matrix, dp), f(col + 1, row + 1, matrix, dp)));
        
    }
}