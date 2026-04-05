class Solution {
    List<String> res;
    StringBuilder path;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        path = new StringBuilder();
        backtrack(n, 0);
        return res;
    }
    public void backtrack(int n, int opened){
        if (n == 0 && opened == 0){
            res.add(new String(path));
            return;
        }
        if (n > 0) {
            path.append("(");
            backtrack(n - 1, opened + 1);
            path.deleteCharAt(path.length() - 1);
        }
        if (opened > 0){
            path.append(")");
            backtrack(n, opened - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
