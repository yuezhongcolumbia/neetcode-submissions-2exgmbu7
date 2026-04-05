class Solution {
    // choices:
    //     1. pick/not pick
    // state:
    //     i,
    // end:
    //     1.i == n return
    //     2. path.size == k, copy, return
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(n, k, path, 1);
        return res;
    }
    public void backtrack(int n, int k, List<Integer> path, int i){
        if (i > n){
            if (path.size() == k){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        path.add(i);
        backtrack(n, k, path, i + 1);
        path.remove(path.size() - 1);
        backtrack(n, k, path, i + 1);
    }

}