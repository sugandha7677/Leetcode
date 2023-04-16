class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int []ans = new int[nums.length];
        
        int k = 0;
        int pc = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                ans[k++] = nums[i];
                nums[i] = (int)1e9;
            }
            else if(nums[i] == pivot) {
                pc++;
                nums[i] = (int)1e9; 
            }
        }
        
        while(pc-- > 0){
            ans[k++] = pivot;
        }
        
        for(int i =0; i < nums.length; i++){
            if(nums[i] != 1e9){
                ans[k++] = nums[i];
            }
        }
        return ans;
    }
}