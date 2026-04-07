class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1 ) return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        // 1. sort by end time
        // 2. traverse:
        //     1. if overlap, we remove the cur one, which ends further
        //     2. overlap, we keep going 
        //     3. check overlap: prevEnd > curStart
        int count = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (prevEnd > start){
                count++;
            } else {
                prevEnd = end;
            }
        }
        return count;


    }
}
