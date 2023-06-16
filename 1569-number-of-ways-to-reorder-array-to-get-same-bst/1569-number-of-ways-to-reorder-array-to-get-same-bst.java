class Solution {
    private final long MOD = 1000000007;
    private long[][] pascal;

    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n: nums) {
            list.add(n);
        }

        pascal = getPascalTriangle(nums.length);

        return (int) ((dfs(list) - 1) % MOD);
    }
    
    private long dfs(List<Integer> nums) {
        // just one combination if one side have only two elements
        if (nums.size() <= 2) return 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num < root) {
                left.add(num);
            } else {
                right.add(num);
            }
        }

        return (comb(nums.size() - 1, left.size()) * dfs(left) % MOD) * (dfs(right) % MOD) % MOD;
    }

    // return the binomical coefficient C(n, k) with Pascal's triangle
    private long comb(int n, int k) {
        return pascal[n][k];
    }

    private long[][] getPascalTriangle(int n) {
        long[][] triangle = new long[n][n];
        for (int i = 0; i < n; i++) {
            // first column = 1
            triangle[i][0] = 1;
            // diagonal = 1
            triangle[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n; j++) {
                triangle[i][j] = (triangle[i-1][j-1] + triangle[i-1][j]) % MOD;
            }
        }

        return triangle;
    }
    
}