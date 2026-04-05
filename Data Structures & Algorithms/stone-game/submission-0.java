class Solution {
    public boolean stoneGame(int[] piles) {
        return dfs(piles,0,piles.length-1,0,0,true);
    }
    
    private boolean dfs(int[]piles, int l, int r , int alice_stone, int bob_stone, boolean alice ){
        if(l>r){
            if( alice_stone>bob_stone){
                return true;
            }else{
                return false;
            }
        }
        if(alice){
            return dfs(piles,l+1,r,alice_stone+piles[l],bob_stone,!alice)||dfs(piles,l,r-1,alice_stone+piles[r],bob_stone, !alice);
        }else{
            return dfs(piles,l+1,r,alice_stone,bob_stone+piles[l],!alice)||dfs(piles,l,r-1,alice_stone,bob_stone+piles[r],!alice);
        }
    } 
}