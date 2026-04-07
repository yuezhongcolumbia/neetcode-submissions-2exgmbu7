class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            if (cur[1] < intervals[i][0]){
                res.add(cur);
                cur = intervals[i];
            } else {
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }

        }
        res.add(cur);
        
        return res.toArray(new int[res.size()][]);
    }
}