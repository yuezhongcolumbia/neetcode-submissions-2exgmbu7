class Solution {
    private boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        visited = new boolean[n];
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        int subsetSum = sum / k;
        // Arrays.sort(nums);
        // int l = 0, r = n - 1;
        // while (l < r){
        //     int temp = nums[l];
        //     nums[l] = nums[r];
        //     nums[r] = temp;
        //     l++;
        //     r--;
        // }
        return backtrack(nums, subsetSum, 0, 0, k);

    }
    public boolean backtrack(int[] nums, int subsetSum, int curSum, int i, int k){
        if (k == 0) return true;
        if (curSum == subsetSum){
            return backtrack(nums, subsetSum, 0, 0, k - 1);
        }
        for (int j = i; j < nums.length; j++){
            if (!visited[j] && curSum + nums[j] <= subsetSum){
                visited[j] = true;
                if (backtrack(nums, subsetSum, curSum + nums[j], j + 1, k)) return true;
                visited[j] = false;
                if (curSum == 0) return false;
            }
        }
        return false;
    }
}