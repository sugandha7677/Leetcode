class Solution {
    int ans = 0;
    public int uniquePaths(int m, int n) {
        
        boolean [][] visited = new boolean [m][n];
        for(boolean [] a: visited) {
            Arrays.fill(a, false);
        }
        
        int [][] dp = new int [m][n];
        for(int [] d : dp){
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        
        for(int i =0; i < m; i++){
            dp[i][0] = 1;
        }
        
        for(int i =0; i < n; i++){
            dp[0][i] = 1;
        }
        return f(m-1, n-1, visited, dp);
        
        
    }

    
   int f(int i, int j, boolean [][] visited, int [][] dp){
        if(i < 0 || j < 0) return 0;
        
        if(i == 0 && j == 0) {
            return 1;
        }
        
       if(dp [i][j] != Integer.MIN_VALUE) return dp[i][j];
       
        visited[i][j] = true;
        // up
        int up = f(i - 1, j , visited, dp);
        visited[i][j] = false;
        int left = f(i, j - 1, visited, dp);
        
        return dp[i][j] = up + left;
        
    }
    
    private int solve(int m , int n){
        int prev[]=new int[n];
        for(int i=0; i<m; i++){
            int temp[]=new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                }
            
                int up=0;
                int left =0;
            
                if(i>0)
                    up = prev[j];
                if(j>0)
                    left = temp[j-1];
                
                temp[j] = up + left;
            }
            prev = temp;
        }
    
        return prev[n-1];
    }
}