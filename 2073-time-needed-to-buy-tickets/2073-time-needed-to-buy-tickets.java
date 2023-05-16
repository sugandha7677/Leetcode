class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int time = 0;
        
        int idx = 0;
        while(tickets[k] > 0) {
            idx = (idx) % tickets.length;
            
            if(tickets[idx] > 0) {
                tickets[idx] -= 1;
                time++;
            }
            idx++;
        }
        
        return time;
        
    }
}