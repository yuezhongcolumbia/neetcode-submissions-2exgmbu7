class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(m, n, dp, m, n);
    }
    public int dfs(int m, int n, int[][] dp, int i, int j){
        if (i <= 0 || j <= 0){
            return 0;
        }
        if (i == 1 || j == 1){
            return 1;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        return dp[i][j] = dfs(m, n, dp, i - 1, j) + dfs(m, n, dp, i, j - 1);
    }
}
