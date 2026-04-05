class Solution {
    // state: dfs(i)--starting from i, the most number of non-overlapping intervals
    // transition:
    //     1. skip i : dfs(i) = dfs(i + 1)
    //     2. must include i:
    //             res = 1;
    //             for(j = i + 1; j< intervals.length){
    //                 max(res, 1 + dfs(j));
    //             }
    //     3.max(skip, res)
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int mostNonOverlapping = dfs(intervals, dp, 0);
        return n - mostNonOverlapping;

    }
    public int dfs(int[][] intervals, int[] dp, int i){
        int n = intervals.length;
        if (i == n - 1) return 1;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        if (dp[i] != -1){
            return dp[i];
        }
        int skip = dfs(intervals, dp, i + 1);
        int take = 1;
        for (int j = i + 1; j < n; j++){
            if (intervals[i][1] <= intervals[j][0]){
                take = Math.max(take, dfs(intervals, dp, j) + 1);
            }
        }
        return dp[i] = Math.max(skip, take);
    }
}
