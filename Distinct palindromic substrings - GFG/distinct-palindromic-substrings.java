//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// a
// aba
// b
// a
// aa
// a

//6
class Solution 
{ 
    int palindromeSubStrs(String str) { 
        // code here  
    
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j <= str.length(); j++){
                if(isPallindrome(str, i, j - 1)) {
                    String s = str.substring(i, j);
                    //System.out.println(s);
                    if(!set.contains(s)) set.add(s);
                    
                }
            }
        }
        return set.size();
    }
    
    boolean isPallindrome(String str, int i, int j){
        while( i <= j){
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
} 