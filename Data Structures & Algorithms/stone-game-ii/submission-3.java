class Solution {
    public int stoneGameII(int[] piles) {
        int n =piles.length;
        int[][]dp = new int[n][2*n+1];
        
        return dfs(piles,dp,true,0,1);
    }
    //Alice maximum result
    private int dfs(int[]piles,int[][]dp, boolean Alice, int index,int big_m){
        
        if(index == piles.length){
            return 0;
        }
        if(Alice && 2*big_m>=(piles.length-1-index+1)){
            int remain_sum = 0;
            for(int i = index; i < piles.length; i ++){
                remain_sum+= piles[i];
            }
            return remain_sum;
        }
        if(!Alice && 2*big_m>=(piles.length-1-index+1)){
            return 0;
        }
        if(Alice&&dp[index][big_m]!=0){
            return dp[index][big_m];
        }
        int result = 0;
        if(Alice){
            int pre_sum = 0;
            
            for(int i =1; i<=2*big_m ;i++){
                pre_sum += piles[index+i-1];
                int x = i;
                int big_m_next = Math.max(x,big_m);

                result = Math.max(result, pre_sum+dfs(piles,dp,!Alice,index+i,big_m_next));
            }
            dp[index][big_m]=result;
            
        }else{
            
            result=Integer.MAX_VALUE;
            for(int i =1; i<=2*big_m ;i++){
                int x = i;
                int big_m_next = Math.max(x,big_m);
                result = Math.min(result,dfs(piles,dp,!Alice,index+i,big_m_next));
            }
            
        }
        return result;

    }
}