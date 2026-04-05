class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //l = max, r = sum()
        int l = 0, r = 0;
        int res = 0;
        for (int weight: weights){
            l = Math.max(l, weight);
            r += weight;
        }
        while(l <= r){
            int m = (l + r) / 2;
            if (feasible(weights, m, days)){
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    private boolean feasible(int[] weights, int capacity, int limit){
        int days = 1;
        int cumSum = 0;
        for (int weight: weights){
            //cumSum update;
            cumSum += weight;
            if (cumSum > capacity){
                days ++;
                //cumSum reset
                cumSum = weight;
            }
            if (days > limit) return false;
        }
        return true;
    }
}