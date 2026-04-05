class Solution {
    int[] nums;
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        // 1. return:
        //     length of LIS
        // 2. choices:
        //     a. continue previous chain, if cur > prevMax: 1 + dfs(i + 1, cur)
        //         a1. if cur < prevMax, dfs(1 + 1, prevMax)
        //     b. start new: 1 + dfs(i + 1, cur)
        // 3. passing down:
        //     a. prev baseline
        // 4. base condition:
        //     till the end return 0;
        this.nums = nums;
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int res = 1;
        for (int i = 0; i < n; i++){
            res = Math.max(res, dfs(i));

        }
        return res;
        
    }
    public int dfs(int i){
        if (i == nums.length) return 0;
        if (dp[i] != -1){
            return dp[i];
        }
        
        int res = 1;
        for(int j = i + 1; j < nums.length; j++){
            if (nums[j] > nums[i]){
                res = Math.max(res, 1 + dfs(j));
            }
        }



        return dp[i] = res;
    }
}

