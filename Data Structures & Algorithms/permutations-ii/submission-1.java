class Solution {
    List<List<Integer>> res;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int n = nums.length;
        visited = new boolean[n];
        Arrays.sort(nums);
        backtrack(nums, path);
        return res;
        
    }
    public void backtrack(int[] nums, List<Integer> path){
        int n = nums.length;
        if (path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < n; j++){
            if (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1]) continue;
            if (!visited[j]){
                path.add(nums[j]);
                visited[j] = true;
                backtrack(nums, path);
                path.remove(path.size() - 1);
                visited[j] = false;
            }
        }
    }

}