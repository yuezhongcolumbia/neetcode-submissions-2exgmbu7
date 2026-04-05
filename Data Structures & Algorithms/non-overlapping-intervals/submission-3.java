class Solution {
    // state: prevEnd, curInterval, res
    // transition:
    //     if (overlap){
    //         prevEnd = min(prevEnd curInterval[1]);
    //         res++
    //     }else {
    //         prevEnd = curInterval[1];
    //     }
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
      int prevEnd = intervals[0][1];
      int res = 0;
      for (int i = 1; i < intervals.length; i++){
        int[] interval = intervals[i];
        if (prevEnd > interval[0]){
            res++;
            prevEnd = Math.min(prevEnd, interval[1]);
        } else {
            prevEnd = interval[1];
        }
      }   
      return res;
    }
}
