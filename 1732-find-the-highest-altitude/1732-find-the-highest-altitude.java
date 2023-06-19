class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int prev = 0;
        
        for(int i = 0; i < gain.length; i++){
            prev = prev + gain[i];
            
            max = Math.max(prev, max);
        }
        
        return max;
    }
}