class Solution {
    
    // state: 
    //    path, i
    // transition:
    //     sort(desc) //fail fast
    //     for (4 sides, j){
    //         if (match[i] + path[j] <= length){
    //             update path;
    //             if (backtrack(i + 1, path)) return true;
    //             remove from path;
    //         }
    //         if (path[j] == 0)//meaning if empty side 
    //     }
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;
        for (int match: matchsticks){
            sum += match;
        }
        if (sum % 4 != 0) return false;
        int length = sum / 4;
        Arrays.sort(matchsticks);
        int l = 0, r = matchsticks.length - 1;
        while (l < r){
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
            l++;
            r--;
        }
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, 0, length);
        
    }
    boolean backtrack(int[] matchsticks, int[] sides, int i, int length){
        int n = matchsticks.length;
        if ( i == n) return true;
        for (int j = 0; j < 4; j++){
            if (sides[j] + matchsticks[i] <= length){
                sides[j] += matchsticks[i];
                if (backtrack(matchsticks, sides, i + 1, length)) return true;
                sides[j] -= matchsticks[i];
            }
            if (sides[j] == 0) break;
        }
        return false;
    }
}