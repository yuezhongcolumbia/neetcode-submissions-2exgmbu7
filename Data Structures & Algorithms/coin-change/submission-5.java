class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dfs(coins, amount, dp, amount);
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public int dfs(int[] coins, int amount, int[] dp, int currSum){
        if (currSum < 0){
            return Integer.MAX_VALUE;
        }
        if (currSum == 0){
            return 0;
        }
        if (dp[currSum] != -1){
            return dp[currSum];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int next = dfs(coins, amount, dp,currSum - coins[i]);
            if (next == Integer.MAX_VALUE){
                continue;
            }
            res = Math.min(res, 1 + next);

        }
        return dp[currSum] = res;
    }
}
