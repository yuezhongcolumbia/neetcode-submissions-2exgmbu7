class Solution {
    List<Integer> path;
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    //   duplicate, negative number, unsorted, n <= 11
    //   sort, dedup, pruning?  no pruning, n* 2^n
        this.nums = nums;
        path = new ArrayList<>();
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0);
        return res;

    }
    public void backtrack(int idx){
        if (idx == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        
        path.add(nums[idx]);
        backtrack(idx + 1);
        path.remove(path.size() - 1);

        int i = idx;
        while(i < nums.length && nums[i] == nums[idx]){
            i++;
        }
        backtrack(i);
    }
}
