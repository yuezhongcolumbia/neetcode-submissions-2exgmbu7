class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, path, 0, 0);
        return res;
    }
    public void backtrack(String s, List<String> path, int l, int r){
        if (r == s.length()){
            if (l == r){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (isPalindrome(s, l, r)){
            path.add(s.substring(l, r + 1));
            backtrack(s, path, r + 1, r + 1);
            path.remove(path.size() - 1);
        }
        backtrack(s, path, l, r + 1);
    }
    public boolean isPalindrome(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
