class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][0]: max profit you can achieve considering prices[i] to prices[n-1]
        //dp[i][1]: if you have bought the stock prior to prices[i], the max return you can achieve 
        //          considering prices[i] to prices[n -1]
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dfs(prices, n, dp, 0, 0);

    }

    public int dfs(int[] prices, int n, int[][] dp, int i, int bought){
        if (i == n){
            return 0;
        }
        if (dp[i][bought] != -1){
            return dp[i][bought];
        }
        //considering bought before i , what is the max return from i to n-1?
        //it would be max of (max return at i+1, sell at i + max profit from i+1 to n-1)
        if (bought == 1){
            return dp[i][1] = Math.max(dfs(prices, n, dp, i+1, 1),
            prices[i] + dfs(prices, n, dp, i+1, 0));
        } 
        //considering did not buy before i, what is the max profit from i to n-1?
        //it would be max of(max profit from i+1 to n-1, buy at i + max return from i+1 to n-1)
        else {
                return dp[i][0] = Math.max(dfs(prices, n, dp, i+1, 0),
                -prices[i] + dfs(prices, n, dp, i+1, 1));
        }
    }
}