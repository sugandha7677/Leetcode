class Solution {
    
        int [] di = {1, 0 , -1, 0};
        int [] dj = {0, 1, 0, -1};
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int [][]dp = new int [m][n];
       
        
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){ 
                ans = (ans + dfs(grid, i, j, dp)) % (int)(1e9 +7);
            }
        }
        
     return ans;
        
        
    }
    
    int dfs(int [][] grid, int row, int col, int [][]dp){
        if(dp[row][col] != 0) return dp[row][col];
        
       dp[row][col] += 1;
        
        for(int i = 0; i < 4; i++){
            int nrow = row + di[i];
            int ncol = col + dj[i];
            
            if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && 
              grid[row][col] > grid[nrow][ncol]){
                dp[row][col] += dfs(grid, nrow, ncol , dp);
                
                dp[row][col] %= (int)(1e9+7);
            }
        }
        return dp[row][col];
    }
}