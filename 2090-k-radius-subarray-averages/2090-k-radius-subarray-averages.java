class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        if(k == 0) return nums;
        
        
        int [] ans = new int [nums.length ];
        Arrays.fill(ans, -1);
        
        long [] prefix = new long [nums.length + 1];
        
    
        for(int i = 0; i < nums.length; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        for(int i = k; i < nums.length-k ; ++i){
            int fIdx = i - k ;
            int lIdx = i + k;
            
            long subArraySum = prefix[lIdx + 1] - prefix[fIdx];
            
            ans[i] = (int)(subArraySum / (2*k + 1));
        }
        
        return ans;
    }
    int findAvg(int [] nums, int i, int j){
        long sum = 0;
        
        
        for(int k = i; k <= j; k++){
            sum += nums[k];
        }
        
        return (int)(sum / (j - i + 1));
    }
}