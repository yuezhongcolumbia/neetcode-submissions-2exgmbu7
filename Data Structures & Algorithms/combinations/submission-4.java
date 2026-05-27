class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        this.n = n;
        this.k = k;
        backtrack(1);
        return res;

        
    }
    public void backtrack(int i){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j <= n; j++){
            if (path.size() + n - j + 1< k) break;
            path.add(j);
            backtrack(j + 1);
            path.remove(path.size() - 1);
        }
    }
}