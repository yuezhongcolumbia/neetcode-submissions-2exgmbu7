class Solution {
    boolean[] used;
    int[] nums;
    List<Integer> path;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
            // unique, unsorted, positive
            // no pruning logic
            // n!
            path = new ArrayList<>();
            res = new ArrayList<>();
            this.nums = nums;
            used = new boolean[nums.length];
            backtrack();
            return res;            
    }
    public void backtrack(){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack();
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
