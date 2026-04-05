class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        this.nums = nums;
        backtrack(0);
        return res;
    }
    public void backtrack(int i){
        int n = nums.length;
        if (i == n){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        backtrack(i + 1);
        path.remove(path.size() - 1);
        backtrack(i + 1);
    }
}
