class Solution {
    // dp:
    //     return: maxprofit 
    //     states: time, hold/not hold
    //         hold:
    //             1. sell: today price + dfs(i + 1, not hold)
    //             2. continue hold: dfs(i + 1, hold)
    //         not hold:
    //             1.buy: -today price + dfs(i + 1, hold)
    //             2.keep empty: dfs(i + 1, not hold);

    //     base case:
    //         1. time -> end: i == n, return 0
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return dfs(prices, dp, 0, 0);
    }
    public int dfs(int[] prices, int[][] dp, int i, int hold){
        int n = prices.length;
        if (i == n) return 0;
        if (dp[i][hold] != -1){
            return dp[i][hold];
        }   
        int nextHold = dfs(prices, dp, i + 1, 1);
        int nextEmpty = dfs(prices, dp, i + 1, 0);
        int res = 0;
        if (hold == 1){
            res = Math.max(prices[i] + nextEmpty, nextHold);
        } else {
            res = Math.max(-prices[i] + nextHold, nextEmpty);
        }
        dp[i][hold] = res;
        return res;

    }
}