class Solution {
    // state: i, path, 
    // transition:
    //     1.pick one, skip one
    //     2.sort + prune
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, path, 0, target);
        return res;
    }
    public void backtrack(int[] candidates, List<Integer> path, int i, int target){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++){
            int cur = candidates[j];
            if (j  > i && cur == candidates[j - 1]){
                continue;
            } 
            if (target >= cur){
                    path.add(cur);
                    backtrack(candidates, path, j + 1, target - cur);
                    path.remove(path.size() - 1);
            } else {
                    break;
            }
            
            
        }
    }
}
