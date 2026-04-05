class Solution {
    boolean[] visited;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, path);
        return res;
    }
    public void backtrack(int[] nums, int i, List<Integer> path){
        int n = nums.length;
        if (i == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < n; j++){
            if (!visited[j]){
                visited[j] = true;
                path.add(nums[j]);
                backtrack(nums, i + 1, path);
                visited[j] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
