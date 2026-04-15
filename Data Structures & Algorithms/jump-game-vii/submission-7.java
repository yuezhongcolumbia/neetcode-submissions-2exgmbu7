class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] memo = new boolean[n];
        memo[0] = true;
        int count = 0;
        for (int i = 1; i < s.length(); i++){
            if (i >= minJump && memo[i - minJump]){
                count++;
            }
            if (i > maxJump && memo[i - maxJump - 1]){
                count--;
            }
            if (count > 0 && s.charAt(i) == '0'){
                memo[i] = true;
            }
        }
        return memo[n - 1];
    }
}