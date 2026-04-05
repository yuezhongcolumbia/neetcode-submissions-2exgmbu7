class Solution {
    public int maxProfit(int[] prices) {
        int nextHold = 0, nextEmpty = 0;
        int curHold = 0, curEmpty = 0;
        for (int i = prices.length - 1; i >= 0; i--){
            curHold = Math.max(prices[i] + nextEmpty, nextHold);
            curEmpty = Math.max(-prices[i] + nextHold, nextEmpty);
            nextHold = curHold;
            nextEmpty = curEmpty;
        }
        return curEmpty;
    }
}