class Solution {
    int[] candidates;
    int target;
    List<Integer> path;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // duplicate, unique combination
        // sort + dedup, pick/not pick 
        this.candidates = candidates;
        this.target = target;
        path = new ArrayList<>();
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, 0);
        return res;

        // 1,2,2,4,5,6,9

    }
    public void backtrack(int i, int curSum){
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < candidates.length; j++){
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            if (curSum + candidates[j] > target) break;
            path.add(candidates[j]);
            backtrack(j + 1, curSum + candidates[j]);
            path.remove(path.size() - 1);
        }
    }
}
