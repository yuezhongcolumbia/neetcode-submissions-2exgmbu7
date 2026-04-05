class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, path, 0);
        return res;
    }
    public void backtrack(int[] nums, List<Integer> path, int i){
        int n = nums.length;
        if (i == n){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        backtrack(nums, path, i + 1);
        path.remove(path.size() - 1);
        int next = i;
        while (next < n && nums[i] == nums[next]){
            next++;
        }
        backtrack(nums, path, next);
    }
}
