//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
     List<String> ans;
    public List<String> find_permutation(String S) {
        // Code here
        ans = new ArrayList<>();
        
        boolean [] visited = new boolean[S.length()];
        
        StringBuilder sb = new StringBuilder();
        f(S, visited, sb);
        
        Collections.sort(ans);
        
        return ans;
        
    }
    
    void f(String s, boolean [] visited, StringBuilder sb){
        
        if(sb.length() == s.length()){
            if(!ans.contains(sb.toString()))  ans.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(!visited[i]){
                sb.append(s.charAt(i));
                visited[i] = true;
                f(s, visited, sb);
                visited[i] = false;
                sb.delete(sb.length() - 1, sb.length());
             }
        }
    }
}