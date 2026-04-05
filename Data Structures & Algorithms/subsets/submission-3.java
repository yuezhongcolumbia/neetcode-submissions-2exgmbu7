class Solution {
    // choies:
    //     1.path add nums[i]
    //     2. path skip nums[i]
    // state:
    //     1. i
    //     2. path
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, 0);
        return res;
    }
    public void backtrack(int[] nums, List<Integer> path, int i){
        int n = nums.length;
        if (i == n){
            List<Integer> copy = new ArrayList<>(path);
            res.add(copy);
            return;
        }
        path.add(nums[i]);
        backtrack(nums, path, i + 1);
        path.remove(path.size() - 1);
        backtrack(nums, path, i + 1);
    }
}
