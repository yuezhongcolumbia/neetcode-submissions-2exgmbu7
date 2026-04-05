class Solution {
    Set<String> wordSet;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>();
        for (String str: wordDict){
            wordSet.add(str);
        }
        res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, path, 0, 0);
        return res;

    }
    public void dfs(String s, List<String> path, int l, int r){
        if (l == s.length()){
            res.add(String.join(" ", path));
            return;
        }
        if (r == s.length()) return;
        String cur = s.substring(l, r + 1);
        if (wordSet.contains(cur)){
            path.add(cur);
            dfs(s, path, r + 1, r + 1);
            path.remove(path.size() - 1);
        }
        dfs(s, path, l, r + 1);
    }
}