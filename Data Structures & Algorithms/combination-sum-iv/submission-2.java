class Solution {
    int[] memo;
    int[] nums;
    int target;
    public int combinationSum4(int[] nums, int target) {
        // distinct, target
        // [1,2,3] , target = 4 -> 
        // 1. it is asking how many ways, not the specific subset so backtracking is probably not idea
        //     and there is subproblem involved
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
       return  dfs(target);
       
        
    }
    public int dfs(int curSum){
        if (curSum == 0){
            return 1;
        }
        if (memo[curSum] != -1 ){
            return memo[curSum];
        }
        int res = 0;
        for (int num: nums){
            if (num <= curSum){
                res += dfs(curSum - num);
            }
        }
        return memo[curSum] = res;
    }
}