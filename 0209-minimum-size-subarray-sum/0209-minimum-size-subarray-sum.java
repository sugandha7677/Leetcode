class Solution {
    public int minSubArrayLen(int x, int[] a) {
        int start = 0;
        int end = 0;
        int sum = a[start];
        if(sum > x) return 1;
        
        int res = Integer.MAX_VALUE;
        int n = a.length;
        while(start < n && end < n){
            
            if(sum >= x){
                res = Math.min(res , end - start +1);
                sum -= a[start];
                start++;
            }else{
                end++;
                if(end < n) sum += a[end];
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}