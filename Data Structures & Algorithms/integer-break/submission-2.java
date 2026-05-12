class Solution {
    int[] memo;
    int n;
    
    public int integerBreak(int n) {
        // problem: break it into k parts, 

        // dp with memoization:
        // 1. choices: using a for loop to calculate every state between 1 and n, memoize it
        // 2. return: max(num, additive + dfs(...))
        this.n = n;
        if (n == 2) return 1;
        if (n == 3) return 2;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[2] = 2;
        memo[3] = 3;
        return dfs(n);
        
     

    }
    public int dfs(int x){
        if (memo[x] != -1){
            return memo[x];
        }
        int res = 0;
        for(int i = 2; i <= x-2; i++){
            res = Math.max(res, i * dfs(x - i));
        }
        return memo[x] = res;
    }
}