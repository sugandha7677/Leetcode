class Solution {
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
    
    
}