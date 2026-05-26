class Solution {
    int[] matchsticks;
    int sideLen;
    boolean[] used;
    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        int sum = 0;
        for (int match: matchsticks){
            sum += match;
        }
        if (sum % 4 != 0) return false;
        used = new boolean[matchsticks.length];
        sideLen = sum / 4;
        return backtrack(0, 0, 0);
    }
    public boolean backtrack(int start, int curSum, int sides){
        if (sides == 4) return true;
        if (curSum == sideLen){
            return backtrack(0, 0, sides + 1);
        }
        for (int i = start; i < matchsticks.length; i++){
            if (used[i] || matchsticks[i] + curSum > sideLen) continue;
            used[i] = true;
            if (backtrack(start + 1, curSum + matchsticks[i], sides)) return true;
            used[i] = false;
            if (curSum == 0) return false;
        }
        return false;
    }
}