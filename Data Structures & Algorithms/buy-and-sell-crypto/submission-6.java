class Solution {
    public int maxProfit(int[] prices) {
      int result = 0;
      int profit = 0;
      int l = 0;
      for(int r = 0; r < prices.length;r++){
        profit = prices[r] - prices[l];
        result = Math.max(profit, result);
        while(l<r &&prices[l+1]<=prices[l]){
            
            l++;
        }
        if(prices[r]<=prices[l]){
            l = r;
        }
      }  
      return result;
    }
}
