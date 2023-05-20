class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        
        int lo = 0;
        int hi = x / 2;
        
        int s = 0;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if((long)mid * mid == x ) return mid;
            
            else if((long)mid*mid < x) {
                s = mid;
                lo = mid + 1;
                
            }
            
            else hi = mid - 1;
        }
        
        return s;
    }
}