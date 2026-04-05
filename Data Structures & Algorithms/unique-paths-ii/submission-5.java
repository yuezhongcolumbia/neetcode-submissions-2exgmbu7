class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 1 && j == 1){
                    dp[i][j] = 1;
                } else{
                    dp[i][j] = -1;
                }
            }
        }
        return dfs(obstacleGrid, dp, m, n);
    }
    public int dfs(int[][] grid, int[][]dp, int i, int j){
        if (i <= 0 || j <= 0){
            return 0;
        }
        if (grid[i - 1][j - 1] == 1){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        return dp[i][j] = dfs(grid, dp, i - 1, j) +
                            dfs(grid, dp, i, j - 1);
    }
}