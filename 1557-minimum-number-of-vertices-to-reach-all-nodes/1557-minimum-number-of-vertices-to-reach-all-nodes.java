class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        boolean [] isIncomingEdgeExists = new boolean[n];
        
        Arrays.fill(isIncomingEdgeExists, false);
        
        for(List<Integer> edge : edges){
            isIncomingEdgeExists[edge.get(1)] = true;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(isIncomingEdgeExists[i] == false){
                ans.add(i);
            }
        }
        
        return ans;
    }
}