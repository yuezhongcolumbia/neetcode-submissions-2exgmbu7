class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile: piles){
            r = Math.max(r, pile);
        }
        int res = 0;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (feasible(piles, mid, h)){
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
    public boolean feasible(int[] nums, int rate, int limit){
        int time = 0;
        for (int num: nums){
            time += (num + rate - 1) / rate;
            if (time > limit){
                return false;
            }
        }
        return true;
    }
}
