class Solution {
    public String firstPalindrome(String[] words) {
     
        for(int  i =0; i < words.length; i++){
            if(isPallindrome(words[i], 0 , words[i].length() - 1)) return words[i];
        }
        
        return "";
    }
    
    boolean isPallindrome(String s, int i, int j ){
        while(i <= j ){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        
        return true;
    }
}