class Solution {
    public int[] runningSum(int[] nums) {
        
        if(nums.length == 1) return nums;
        
        int [] rSum = new int [nums.length];
        rSum[0] = nums[0];
        
        for(int  i = 1; i < nums.length; i++){
            rSum[i] = rSum[i-1] + nums[i];
        }
        
        return rSum;
    }
}