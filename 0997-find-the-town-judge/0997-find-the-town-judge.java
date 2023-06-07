class Solution {
    public int findJudge(int n, int[][] trust) {
        

        int [] indegree = new int [n + 1];
        int [] outdegree = new int [n + 1];
        
        Arrays.fill(indegree, 0);
        Arrays.fill(outdegree, 0);
        
        for(int i = 0; i < trust.length; i++){
            int src = trust[i][0];
            int dest = trust[i][1];
            
            indegree[dest] += 1;
            outdegree[src] += 1;
        }
        
        
        
        for(int i = 1; i < indegree.length; i++){
           if(indegree[i] == n -1 && outdegree[i] == 0) return i;
        }
        
        return -1;
    }
}