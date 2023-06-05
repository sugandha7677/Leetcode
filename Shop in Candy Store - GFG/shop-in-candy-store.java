//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> cost = ob.candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // code here
        Arrays.sort(candies);
        ArrayList<Integer> ans = new ArrayList<>();
        
        int min = 0;
        int i = 0;
        int j = candies.length - 1;
        
        while(i <= j){
            min += candies[i];
            i++;
            j -=K;
        }
        ans.add(min);
        
        int max = 0;
        i = 0;
        j = candies.length - 1;
        
        while( j >= i){
            max += candies[j];
            j--;
            i += K;
        
        }
        ans.add(max);
        return ans;
        
    }
}