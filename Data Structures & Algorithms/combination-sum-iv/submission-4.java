class Solution {
    int[] nums;
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        // distinct
        // >= 1
        // not sorted

        // no sorting is necessary
        // dp.
        // so does dp state record different order?
        this.nums = nums;
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(target);
        


    }
    public int dfs(int target){
        if (target == 0) return 1;
        if (memo[target] != -1) return memo[target];
        int res = 0;
        for (int num: nums){
            if (num > target) continue;
            res += dfs(target - num);
        }
        return memo[target] = res;
    }
}