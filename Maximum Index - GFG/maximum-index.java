//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int A[], int N) {
        // code here
        Stack<Integer> stkForIndex = new Stack<>();
         
        //loop for storing index in stack whose value appears in decreasing order
        for(int i=0;i<N;i++){           
            if(stkForIndex.isEmpty() || A[stkForIndex.peek()]>A[i])
                stkForIndex.push(i);
        }
 
        int maxDiffSoFar = 0;
        int tempdiff;
         
        //Now we traverse from right to left.
        int i = N-1;
        while(i>=0){

            if(!stkForIndex.isEmpty() && A[stkForIndex.peek()] <= A[i]){
                tempdiff = i - stkForIndex.pop();
                if(tempdiff>maxDiffSoFar){
                    maxDiffSoFar  = tempdiff;
                }
                continue;
            }           
            i--;
        }
 
        return maxDiffSoFar;
        
    }
}