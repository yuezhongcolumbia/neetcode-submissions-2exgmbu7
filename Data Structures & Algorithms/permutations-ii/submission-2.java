class Solution {
    List<Integer> path;
    List<List<Integer>> res;
    int[] nums;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        // duplicate, negative number, unsorted, n <=8, permutations

        // 1,1,2, sort + 同层去重。没有pruning
        //卡点， used + dedup 导致有些元素没法被选

        // 1,1,2 
        // 1,1,2  1,2
        path = new ArrayList<>();
        res = new ArrayList<>();
        this.nums = nums;
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack();
        return res;
    }
    public void backtrack(){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if ((i > 0 && nums[i] == nums[i - 1]) && !used[i - 1]) continue;
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack();
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}