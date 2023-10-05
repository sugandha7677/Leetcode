//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        
        int max = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean [][] vis = new boolean [n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]) {
                   
                    int count = dfs(grid, i, j, vis);
                    max = Math.max(max, count);
                }
            }
        }
        
        return max;
    }
    
    int [] di = {1, 0, -1, 0, -1, 1, 1, -1};
    int [] dj = {0, 1, 0, -1, 1, 1, -1, -1};
    
    int dfs(int [][] grid, int i, int j, boolean [][] vis){
       
        int count = 1;
        vis[i][j] = true;
        
        for(int k = 0; k < 8; k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            
            if(isValid(grid, ni, nj, vis)){
                count += dfs(grid,ni, nj, vis);
            }
        }
        
        return count;
    }
    
    boolean isValid(int [][] grid, int i, int j, boolean [][] vis){
        
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && !vis[i][j] &&
                grid[i][j] == 1);
    }
}