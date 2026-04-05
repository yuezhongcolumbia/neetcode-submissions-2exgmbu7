class Solution {
    int[] dp;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        this.coins = coins;
        Arrays.fill(dp, -1);
        int res = dfs(amount);
        return res != Integer.MAX_VALUE / 2 ? res : -1;
        
    }
    public int dfs(int amount){
        if (amount == 0){
            return 0;
        }

        if (dp[amount] != -1){
            return dp[amount];
        }
        int res = Integer.MAX_VALUE / 2;
        for (int coin: coins){
            if (amount - coin >= 0){
               res = Math.min(res, 1 + dfs(amount - coin) ); 
            }
        }   
        return dp[amount] = res;
    }
}
