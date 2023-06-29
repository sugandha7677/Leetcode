class Solution {
    public int numIdenticalPairs(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int count = entry.getValue();
            sum += Math.floor((count * (count - 1)) / 2);
        }
        
        return sum;
    }
}