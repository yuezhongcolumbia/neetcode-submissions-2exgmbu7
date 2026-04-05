class Solution {
    // state: path， i, open, close
    // choices:
    //     path:
    //         open: can append "(" as long as open < n;
    //             1. transition, dfs(open + 1, close)
    //         close: can append ")" as long as open > close
    //             1.transition, dfs(open, close + 1);
    // terminal:
    //     open == close && open == n;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack(n, path, 0, 0);
        return res;
    }
    public void backtrack(int n, StringBuilder path, int open, int close){
        if (open == close && open == n){
            res.add(path.toString());
        }
        if (open < n){
            path.append("(");
            backtrack(n, path, open + 1, close);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open){
            path.append(")");
            backtrack(n, path, open, close + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
