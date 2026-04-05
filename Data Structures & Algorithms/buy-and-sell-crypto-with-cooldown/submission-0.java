class Solution {
    int[][] memo;
    int[] prices;
    public int maxProfit(int[] prices) {
        // what algo? not graph -> min/max -> no monotonic condition -> dp
        // return: max profit
        // choice:
        //     1. carry
        //         1. sell prices[i] + dfs(i + 2, not carry )
        //         2. carry dfs(i + 1, carry);
        //     2. no carry
        //         1. buy -prices[i] + dfs(i + 1, carry)
        //         2. skip dfs(i + 1, not carry);
        this.prices = prices;
        int n = prices.length;
        memo = new int[n + 1][2];
        for (int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return dfs(0, 0);

        
    }
    public int dfs(int i, int carry){
        if (i >= prices.length){
            return 0;
        }
        if (memo[i][carry] != -1){
            return memo[i][carry];
        }
        int res = 0;
        if (carry == 1){
            res = Math.max(prices[i] + dfs(i + 2, 0),
                     dfs(i + 1, 1));
        }
         else {
            res = Math.max(-prices[i] + dfs(i + 1, 1),
                    dfs(i + 1, 0));
        }
        return memo[i][carry] = res;
    }
}
