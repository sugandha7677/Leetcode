class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<Boolean>();
        
        int max = Integer.MIN_VALUE;
        
        for(int c : candies){
            max = Math.max(max, c);
        }
        
        for(int c : candies){
            if (c + extraCandies >= max){
                ans.add(true);
            }
            else ans.add(false);
        }
        
        return ans;
    }
}