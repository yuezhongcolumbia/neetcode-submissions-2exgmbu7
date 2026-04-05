class Solution {
    // choices:
    //     1. take one, skip one; 
    //     2. in order to not have dup, we have to skip using while to skip
    // state:
    //     1. i
    // copy:
    //     when i == n
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
        while (i + 1 < n && nums[i + 1] == nums[i] ){
            i++;
        }
        path.remove(path.size() - 1);
        backtrack(nums, path, i + 1);

    }
}
