class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dfs(cost, dp, 0);
        return Math.min(dp[0], dp[1]);
    }
    public int dfs(int[] cost, int[] dp, int curr){
        if (curr >= cost.length){
            return 0;
        }
        if (dp[curr] != 0){
            return dp[curr];
        }
        int oneStep = cost[curr] + dfs(cost, dp, curr + 1);
        int twoStep = cost[curr] + dfs(cost, dp, curr + 2);
        return dp[curr] = Math.min(oneStep, twoStep);
    }

}
