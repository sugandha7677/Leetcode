class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == val){
                nums[j] = 0;
            }else {
                nums[i] = nums[j];
                
                i++;
            }
        }
        return i ;
    }
}