class Solution {
     private int[] memo;
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        memo = new int[n];
        Arrays.fill(memo, -1);

        int maxNonOverlapping = dfs(intervals, 0);
        return n - maxNonOverlapping;
    }
    private int dfs(int[][] intervals, int i) {
    if (i == intervals.length) return 0;
    if (memo[i] != -1) return memo[i];

    // 1) skip i
    int res = dfs(intervals, i + 1);

    // 2) take i
    int bestTake = 1;
    for (int j = i + 1; j < intervals.length; j++) {
        if (intervals[i][1] <= intervals[j][0]) {
            bestTake = Math.max(bestTake, 1 + dfs(intervals, j));
        }
    }
    res = Math.max(res, bestTake);

    return memo[i] = res;
}
}
