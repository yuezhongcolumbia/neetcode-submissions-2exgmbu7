class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int weight: weights){
            r += weight;
            l = Math.max(l, weight);
        }
        int res = 0;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (feasible(weights, mid, days)){
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
    public boolean feasible(int[] nums, int weight, int limit){
        int days = 1, curSum = 0;
        for(int num: nums){
            curSum += num;
            if (curSum > weight){
                days++;
                curSum = num;
            }
            if (days > limit) return false;
        }
        return true;
    }
}