class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        
        int j=0;
        while(j<n){
            if(nums[j]!=min && nums[j]!=max) {
                
                return nums[j];
            }else{
                j++;
            }
        }
        return -1;
        
    }
}