class Solution {
    // 1. choices:
    //     cannot choose the chosen ones, use visited
    // 2. base:
    //     i == n
    // 3. state
    //     i
    List<List<Integer>> res;
    Set<Integer> visited;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path, 0);
        return res;
    }
    public void backtrack(int[] nums, List<Integer> path, int i){
         int n = nums.length;
         if (i == n){
            res.add(new ArrayList<>(path));
            return;
         }
         for (int start = 0; start < n; start++){
            if (!visited.contains(nums[start])){
                visited.add(nums[start]);
                path.add(nums[start]);
                backtrack(nums, path, i + 1);
                visited.remove(nums[start]);
                path.remove(path.size() - 1);
            }
         }
    }
    
}
