class Solution {
    StringBuilder path;
    List<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        // n = 1 ()
        // n = 2 ()() (())
        // n = 3 ()()() (())() ()(()) ((()))
        // you can always start with left quotation, for n times
        // you can choose right quotation if you have unclosed left quoation

        // state:
        // 1. left quotation used , < n, l1
        // 2. open quotation >=0 <=n, l2

        // base condition: l1 ==n, l2 == 0

        // time complexity: ?
        path = new StringBuilder();
        res = new ArrayList<>();
        this.n = n;
        backtrack(0, 0);
        return res;

    }
    public void backtrack(int l1, int l2){
        if (l1 == n && l2 == 0){
            res.add(new String(path));
            return;
        }
        if (l1 < n){
            path.append("(");
            backtrack(l1 + 1, l2 + 1);
            path.deleteCharAt(path.length() - 1);
        }
        if (l2 > 0){
            path.append(")");
            backtrack(l1, l2 - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
