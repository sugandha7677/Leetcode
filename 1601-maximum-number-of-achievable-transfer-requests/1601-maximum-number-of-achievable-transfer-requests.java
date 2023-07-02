class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int answer = 0;

        for (int mask = 0; mask < (1 << requests.length); mask++) {
            int[] indegree = new int[n];
            int pos = requests.length - 1;

            int bitCount = Integer.bitCount(mask);

            
            if (bitCount <= answer) {
                continue;
            }

            // For all the 1's in the number, update the array indegree for the building it involves.
            for (int curr = mask; curr > 0; curr >>= 1, pos--) {
                if ((curr & 1) == 1) {
                    indegree[requests[pos][0]]--;
                    indegree[requests[pos][1]]++;
                }
            }

            boolean flag = true;
            // Check if it doesn;t violates the constraints
            for (int i = 0; i < n; i++) {
                if (indegree[i] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)  {
                answer = bitCount;
            }
        }

        return answer;
    }
}