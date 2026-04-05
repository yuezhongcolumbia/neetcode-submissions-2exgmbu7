class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(n, k, path, 1);
        return res;
    }
    public void backtrack(int n, int k, List<Integer> path, int i){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        if (i > n){
            return;
        }
        path.add(i);
        backtrack(n, k, path, i + 1);
        path.remove(path.size() - 1);
        backtrack(n, k, path, i + 1);
    }
}