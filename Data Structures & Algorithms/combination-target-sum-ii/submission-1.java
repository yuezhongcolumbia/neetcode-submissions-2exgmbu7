class Solution {
    // 1. duplicate, choose once for each element
    // 2. choices:
    //     start from i + 1
    // 3. state:
    //     i, curSum
    // 4. optimize:
    //     sort + early stop

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, path, 0, 0);
        return res;
    }
    public void backtrack(int[] candidates, int target, List<Integer> path, int i, int curSum){
        int n = candidates.length;
        //found, copy
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int start = i; start < n; start++){
            if (start > i && candidates[start] == candidates[start - 1]){
                continue;
            }
            if (curSum + candidates[start] > target){
                return;
            }
            //update path
            path.add(candidates[start]);
            
            //recursion
            backtrack(candidates, target, path, start + 1, curSum + candidates[start]);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
