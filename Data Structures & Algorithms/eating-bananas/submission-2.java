class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //l = 1,  r = max(piles)
        int l = 1, r = 0;
        for (int pile: piles){
            r = Math.max(r, pile);
        }
        int res = -1;
        while (l <= r){
            int m = (l + r) / 2;
            if (feasible(piles, m, h)){
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    public boolean feasible(int[] piles, int rate, int limit){
        int time = 0;
        for (int pile: piles){
            time += (pile + rate - 1) / rate;
            if (time > limit) return false;
        }
        return true;
    }
}
