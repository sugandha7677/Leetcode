class Solution {
    
    //A1. Brute
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
    
    // TC: O(n) + O(n)
    // SC: O(1)
    
    //A2.
    
    public int[] pivotArray(int[] nums, int pivot) {
        
        int small = 0;
        int same = 0;
        
        for(int i =0; i < nums.length; i++){
            
            if(nums[i] < pivot) ++small;
            
            else if(nums[i] == pivot) ++same;
        }
        
        int big = small + same;
        int [] res = new int[nums.length];
        same = small;
        small = 0;
        
        for(int i =0; i < nums.length; i++){
            
            if(nums[i] < pivot){
                res[small++] = nums[i];
            }
            else if(nums[i] == pivot){
                res[same++] = pivot;
            }
            else res[big++] = nums[i];
        }
        
        return res;
    }
    
    //TC: O(N)
    //SC: O(N)
}
