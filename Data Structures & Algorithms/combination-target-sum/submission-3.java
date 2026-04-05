class Solution {
    List<List<Integer>>res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        backtrack(nums, target, path, 0);
        return res;
    }
    public void backtrack(int[] nums, int target, List<Integer> path, int i){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length; j++){
            if (target - nums[j] >= 0){
                path.add(nums[j]);
                backtrack(nums, target - nums[j], path, j);
                path.remove(path.size() - 1);
                
            }
        }
    }
}
