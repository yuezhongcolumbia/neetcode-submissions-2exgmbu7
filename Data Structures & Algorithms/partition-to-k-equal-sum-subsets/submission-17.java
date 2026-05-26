class Solution {
    int[] nums;
    int k;
    int partitionSum;
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        used = new boolean[nums.length];
        partitionSum = sum / k;
        return backtrack( 0, 0);

    }
    public boolean backtrack(int curSum, int bucket){
        if(bucket == k) return true;
        if (curSum == partitionSum){
            return backtrack( 0, bucket + 1);
        }
        for (int j = 0; j < nums.length; j++){
            if (used[j] || curSum + nums[j] > partitionSum) continue;
            used[j] = true;
            if (backtrack(curSum + nums[j], bucket)) return true;
            used[j] = false;
            if (curSum == 0) break;
        }
        return false;
        
    }
}