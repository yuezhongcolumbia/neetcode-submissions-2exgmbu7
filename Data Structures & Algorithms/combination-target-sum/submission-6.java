class Solution {
    int[] nums;
    int target;
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, 0);
        return res;
    }
    public void backtrack(int i, int curSum){
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length; j++){
            if (curSum + nums[j] <= target){
                path.add(nums[j]);
                backtrack(j, curSum + nums[j]);
                path.remove(path.size() - 1);
            } else {
                return;
            }
            
        }
    }
}
