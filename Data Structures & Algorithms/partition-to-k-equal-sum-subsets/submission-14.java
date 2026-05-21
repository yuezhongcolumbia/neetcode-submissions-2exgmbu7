class Solution {
    boolean[] visit;
    int[] nums;
    int k;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        this.k = k;
        visit = new boolean[n];
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        int partition = sum / k;
        Arrays.sort(nums);
        reverse(nums);
        if (nums[0] > partition) return false;
        return backtrack(0, 0, partition);
    }
    public boolean backtrack(int bucket, int curSum, int partition){
        if (bucket == k) return true;
        if (curSum == partition){
            return backtrack(bucket + 1, 0, partition);
        }
        for(int i = 0; i < nums.length; i++){
            if (visit[i]) continue;
            if (nums[i] + curSum > partition) return false;
            visit[i] = true;
            if (backtrack(bucket, curSum + nums[i], partition)) return true;
            visit[i] = false;
        }
        return false;
    }
    public void reverse(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}