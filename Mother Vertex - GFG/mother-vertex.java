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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] vis = new boolean[V];
        int lastVisited = 0; // Initialize the last visited vertex
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                vis[i] = true;
                lastVisited = i; // Update the last visited vertex
                dfs(adj, i, vis);
            }
        }
        
             // Check if the lastVisited vertex is a mother vertex
        Arrays.fill(vis, false); // Reset visited array
        dfs(adj, lastVisited, vis);
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                return -1; // There is no mother vertex
            }
        }
        return lastVisited;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis) {
        vis[node] = true;
        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                dfs(adj, nbr, vis);
            }
        }
    }

}