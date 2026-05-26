class Solution {
    List<Integer> path;
    List<List<Integer>> res;
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // unlimited times, distinct
        // time?

        path = new ArrayList<>();
        res = new ArrayList<>();
        this.nums = nums;
        this.target = target;
        Arrays.sort(nums);

        backtrack(0, 0);
        return res;

    }
    public void backtrack(int start, int curSum){
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if (curSum + nums[i] > target) break;
            path.add(nums[i]);
            backtrack(i, curSum + nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
