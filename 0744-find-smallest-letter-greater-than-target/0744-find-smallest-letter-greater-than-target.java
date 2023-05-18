class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int lo = 0;
        int hi = letters.length - 1;
        
        char ceil = '$';
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(letters[mid] > target) {
                ceil = letters[mid];
                hi = mid - 1;
            }
            else if(letters[mid] <= target ){
                lo = mid + 1;
            }
            
        }
        return ceil == '$' ? letters[0] : ceil;
    }
}