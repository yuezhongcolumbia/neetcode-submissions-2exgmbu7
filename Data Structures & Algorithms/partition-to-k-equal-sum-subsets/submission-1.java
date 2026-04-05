class Solution {
    // 1. it is the same with matchbox problem
    // state:
    //     1. i, int[] path

    // choice:
    //     2. putting i into k boxes, 
    //     3. for(boxes){
    //         if (boxes + nums[i] < sum){
    //             update box;
    //             if (dfs()) return true
    //             backtrack;
    //             if (boxes == 0) break;
    //         }
    //     }
    //     return false
    // termination: i == n
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % k != 0) return false;
        int subsetSum = sum / k;
        Arrays.sort(nums);
        int l = 0, r = n - 1;
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        int[] path = new int[k];
        return backtrack(nums, path, 0, subsetSum);
    }
    public boolean backtrack(int[] nums, int[] path, int i, int subsetSum ){
        int n = nums.length;
        if (i == n) return true;
        for (int j = 0; j < path.length; j++){
            if (path[j] + nums[i] <= subsetSum){
                path[j] += nums[i];
                if (backtrack(nums, path, i + 1, subsetSum)) return true;
                path[j] -= nums[i];
                if (path[j] == 0) break;
            }
        }
        return false;
    }
}