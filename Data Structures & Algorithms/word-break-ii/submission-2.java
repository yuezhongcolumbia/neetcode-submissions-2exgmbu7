class Solution {
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String str: wordDict){
            wordSet.add(str);
        }
        backtrack(s, wordSet, path, 0);
        return res;
        
    }
    public void backtrack(String s, Set<String> wordSet, List<String> path, int i){
        if (i == s.length()){
            String snapShot = String.join(" ", path);
            res.add(snapShot);
            return;
        }
        for (int j = i; j < s.length(); j++){
            String cur = s.substring(i, j + 1);
            if (wordSet.contains(cur)){
                path.add(cur);
                backtrack(s, wordSet, path, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}