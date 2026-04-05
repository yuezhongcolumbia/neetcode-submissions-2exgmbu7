class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i], -1);
        }
         dp[1][1] = grid[0][0];
        return dfs(grid, dp, m, n);
    }
    public int dfs(int[][] grid, int[][] dp, int i, int j){
        if ( i <= 0 || j <= 0){
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        return dp[i][j] = grid[i - 1][j - 1] + Math.min(
            dfs(grid, dp, i - 1, j),
            dfs(grid, dp, i, j - 1));
    }
}