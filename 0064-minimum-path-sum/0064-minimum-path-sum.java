class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int [][]dp = new int [m][n];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        
        for(int i = 1; i < n; i++) dp[0][i] = grid[0][i] + dp[0][i-1];
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m-1][n-1];
    }
    
    int f(int i , int j, int [][] grid, int [][] dp){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
            
        if( i == 0 && j == 0 ) return grid[0][0];
        
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        
        int up = f(i-1, j, grid, dp);
        int left = f(i , j -1, grid, dp);
        
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}