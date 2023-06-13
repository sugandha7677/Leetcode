class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int [] row : grid){
            String s = Arrays.toString(row);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        int count = 0;
        
        for(int c = 0; c < grid[0].length; c++ ){
            int [] a = new int [grid.length];
            for(int r = 0; r < grid.length; r++){
                a[r] = grid[r][c];
            }
            
            count += map.getOrDefault(Arrays.toString(a), 0);
        }
        
        return count;
    }
}