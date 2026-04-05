class Solution {
    // state: visited, curSum, k;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        int bucketSum = sum / k;
        Arrays.sort(nums);
        reverse(nums);
        visited = new boolean[n];
        return backtrack(nums, bucketSum, 0, k);
       
    }
    public boolean backtrack(int[] nums, int bucketSum, int curSum, int k){
        if (k == 0) return true;
        if (curSum == bucketSum){
            return backtrack(nums, bucketSum, 0, k - 1);
        }
        for (int i = 0; i < nums.length; i++){
            if (!visited[i] && curSum + nums[i] <= bucketSum){
                visited[i] = true;
                if (backtrack(nums, bucketSum, curSum + nums[i], k))return true;
                visited[i] = false;
            }
        }
        return false;


    }
    public void reverse(int[] nums){
        int l = 0, r = nums.length - 1;
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}