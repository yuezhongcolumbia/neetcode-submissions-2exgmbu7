class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxRate = Integer.MIN_VALUE;
        int res = maxRate;
        for (int pile: piles){
            maxRate = Math.max(maxRate, pile);
        }
        int l = 1, r = maxRate;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (feasible(piles, m, h)){
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    public boolean feasible(int[] piles, int r, int h){
        int count = 0;
        for (int pile: piles){
            count += (pile + r - 1) / r;
            if (count > h) return false;
        }
        return true;
    }
}
