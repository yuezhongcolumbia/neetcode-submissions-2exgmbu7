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
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        backtrack(nums, target, path, 0, 0 );
        return res;
    }
    public void backtrack(int[] nums, int target, List<Integer> path, int curSum, int i){
        int n = nums.length;
        if (curSum == target){
            // List<Integer> copy = new ArrayList<>(path);
            // res.add(copy);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int start = i; start < n; start++){
            if (curSum + nums[start] > target) return;
            path.add(nums[start]);
            backtrack(nums, target, path, curSum + nums[start], start);
            path.remove(path.size() - 1);
        }
        
    }
}
