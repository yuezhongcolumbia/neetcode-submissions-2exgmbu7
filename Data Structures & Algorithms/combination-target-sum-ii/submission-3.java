class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        backtrack(0, 0);
        return res;
    }
    public void backtrack(int i, int curSum){
        int n = candidates.length;
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if (i == n){
            return;
        }
        for (int j = i; j < n; j++){
            if (curSum + candidates[j] <= target){
                if (j > i && candidates[j] == candidates[j - 1]) continue;
                if (candidates[j] + curSum <= target){
                    path.add(candidates[j]);
                    backtrack(j + 1, curSum + candidates[j]);
                    path.remove(path.size() - 1);
                } else {
                    return;
                }
                
            }
        }
    }
}
