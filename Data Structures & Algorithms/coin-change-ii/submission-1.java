class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int i = 0; i <= amount; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(coins, amount, dp, amount, 0);
        
    }
    public int dfs(int[] coins, int amount, int[][] dp, int targetSum, int start){
        if (targetSum == 0){
            return 1;
        }
        if (targetSum < 0){
            return 0;
        }
        if (dp[targetSum][start] != -1){
            return dp[targetSum][start];
        }
        int res = 0;
        for(int i = start; i < coins.length; i++){
            res += dfs(coins, amount, dp, targetSum - coins[i], i);
        }
        return dp[targetSum][start] = res;
    }
}
