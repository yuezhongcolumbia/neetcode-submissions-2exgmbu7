class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval: intervals){
            if (newInterval == null || interval[1] < newInterval[0]){
                res.add(interval);
            } else if (interval[0] > newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }

        }
        if (newInterval != null){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);



    }
    // public boolean overlap(int[] a, int[] b){
    //     return a[1] >= b[0] || b[1] >= a[0];
    // }
    // public int[] merge(int[] a, int[] b){    
    //     return new int[2]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    // }
}
