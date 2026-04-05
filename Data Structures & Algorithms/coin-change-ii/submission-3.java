class Solution {
    int[][] memo;
    int amount;
    int[] coins;
    public int change(int amount, int[] coins) {
        // unlimited pick, how many combinations
        // return:  starting of i, how many ways of sum up to target dfs(i, target)
        // choices:
        //     1. pick: dfs(i, target - coins[i]);
        //     2. skip: dfs(i, target);
        // base condition:
        //     1. completion, target == 0, return 1
        //     2. violation: target < 0, return 0
        //         i == n, target > 0
        int n = coins.length;
        memo = new int[n + 1][amount + 1];
        this.amount = amount;
        this.coins = coins;
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return dfs(0, amount);
    }
    public int dfs(int i, int target){
        if (target == 0) return 1;
        if (target < 0 || i == coins.length ){
            return 0;
        }
        if (memo[i][target] != -1){
            return memo[i][target];
        }
        return memo[i][target] = dfs(i, target - coins[i]) + dfs(i + 1, target);
    }

}
