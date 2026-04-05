class Solution {
    // choices:
    //     you can pick any of the number
    //     how to elimnate duplicate?

    // states:
    //     path, curSum
    // base:
    //     curSum > target, we return
    //     curSum == target, we copy
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, target, path, 0, 0 );
        return res;
    }
    public void backtrack(int[] nums, int target, List<Integer> path, int curSum, int i){
        int n = nums.length;
        if (curSum > target || i == n){
            return;
        }
        if (curSum == target){
            List<Integer> copy = new ArrayList<>(path);
            res.add(copy);
            return;
        }
        for (int start = i; start < n; start ++){
            curSum += nums[start];
            path.add(nums[start]);
            backtrack(nums, target, path, curSum, start);
            curSum -= nums[start];
            path.remove(path.size() - 1);
        }
        
    }
}
