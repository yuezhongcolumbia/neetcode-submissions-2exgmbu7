class Solution {
    int[][] memo;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        memo = new int[m + 1][n + 1];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return dfs(0, 0);
    }
    public int dfs(int r, int c){
        if (r >= m || c >= n){
            return 0;
        }
        if (r == m - 1 && c == n - 1){
            return 1;
        }
        if (memo[r][c] != -1){
            return memo[r][c];
        }
        return memo[r][c] = dfs(r + 1, c) + dfs(r, c + 1);
    }
}
