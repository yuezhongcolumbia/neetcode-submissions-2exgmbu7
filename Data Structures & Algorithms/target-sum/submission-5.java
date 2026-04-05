class Solution {
    int[] nums;
    int target;
    int[][] memo;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        // how many ways? -> brute force? what is the time complexity?
        // return: how many ways to reach target
        // choices:
        //     1. add 
        //     2. subtract
        // base condition:
        //     1. target == 0 return 1
        //     2. i == n return 0;
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        sum = 0;
        for (int num: nums){
            sum += num;
        }
        memo = new int[n + 1][2 * sum + 1];
        if (target > sum || target < - sum) return 0;
        for(int[] arr: memo){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return dfs(0, 0);
        
    }
    public int dfs(int i, int curSum){
        if (i == nums.length){
            return curSum == target ? 1 : 0;
        }
        if (memo[i][curSum + sum] != Integer.MIN_VALUE){
            return memo[i][curSum + sum];
        }
        return memo[i][curSum + sum] = dfs(i + 1, curSum - nums[i]) + dfs(i + 1, curSum + nums[i]);
    }
}
