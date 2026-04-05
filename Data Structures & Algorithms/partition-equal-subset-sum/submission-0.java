class Solution {
    Boolean[][] memo;
    int[] nums;
    public boolean canPartition(int[] nums) {
        // return: if you can find subset that sums to target
        // choices: pick one/skip one, 
        //     1. pick one: dfs(i + 1, target - nums[i])
        //     2. skip one: dfs(i + 1, target)
        this.nums = nums;
        int n = nums.length;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum /2;
        memo = new Boolean[n + 1][target + 1];
        return dfs(0, target);
        
    }
    public boolean dfs(int i, int target){
        int n = nums.length;
        if (target == 0) return true;
        if (target < 0 || (i == n && target > 0)) return false;
        if (memo[i][target] != null){
            return memo[i][target];
        }
        return memo[i][target] = dfs(i + 1, target - nums[i]) || dfs(i + 1, target);
    }
}
