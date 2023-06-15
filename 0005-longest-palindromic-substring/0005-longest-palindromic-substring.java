class Solution {
    public String longestPalindrome(String S) {
        String ans="";
        if(S.length()<2)
        return S;
        for(int i=0;i<S.length()-1;i++){
            String even=solve(S,i,i);
            if(even.length()>ans.length()){
                ans=even;
            }
            String odd=solve(S,i,i+1);
            if(odd.length()>ans.length()){
                ans=odd;
            }
        }
        return ans;
    }
    
    
    static String solve(String S,int l,int h){
        while(l>=0 && h<S.length() && S.charAt(l)==S.charAt(h)){
            l--;
            h++;
        }
        return S.substring(l+1,h);
    }
}
