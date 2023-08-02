//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int min = -1;
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        
        if(A[0][0] == 0) return -1;
        
        min = Math.max(min, bfs( A, X, Y));
        
        return min ;
    }
    
    int [] di = {0, 1, 0, -1};
    int [] dj = {1, 0, -1, 0};
    
    int bfs(int [][] arr, int x , int y){
        
     Queue<tuple> q = new LinkedList<>();
     
     boolean [][] visited = new boolean[arr.length][arr[0].length];
     
      q.add(new tuple(0, 0, 0));
      visited[0][0] = true;
      
      while(!q.isEmpty()){
          tuple t = q.poll();
          
          if(t.i == x && t.j == y) return t.steps;
          
          for(int  k = 0; k < 4; k++){
              int ni = t.i + di[k];
              int nj = t.j + dj[k];
              
              if(isSafe(ni, nj, arr, visited)){
                  visited[ni][nj] = true;
                  q.add(new tuple(ni, nj, t.steps + 1));
              }
          }
      }
      
      return -1;
     
    }
    
    boolean isSafe(int i, int j, int [][] arr, boolean [][] visited){
        
        if( i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == true
          || arr[i][j] == 0 ) return false;
          
          return true;
    }
};

class tuple{
    int i;
    int j;
    int steps;
    
    tuple(int i , int j, int steps){
        this.i = i;
        this.j = j;
        this.steps = steps;
    }
}