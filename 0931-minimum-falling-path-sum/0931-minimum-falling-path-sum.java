class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int [][]dp = new int[m][n];
        for(int [] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        
        int ans = Integer.MAX_VALUE;
        for(int row = 0; row < n; row++){
            ans = Math.min(ans, f(0, row, matrix , dp));
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