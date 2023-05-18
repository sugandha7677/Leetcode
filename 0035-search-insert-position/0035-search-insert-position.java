class Solution {
    public int searchInsert(int[] nums, int target) {

        if(nums[nums.length -1] < target) return nums.length;
        if(nums[0] > target) return 0;

        int ceil = -1;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                ceil = mid;
                hi = mid -1;
            }else
                lo = mid +1;
        }
        return ceil;
    }
}