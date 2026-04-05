class Solution {
    // dp:
    // 1. traverse left to right
    // 2. return: List<String>
    // 3. state: i
    // 4. choices:
    //     for (j = i, j < n)
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        for (String str: wordDict){
            wordSet.add(str);
        }
        return dfs(s, wordSet, dp, 0);

    }
    public List<String> dfs(String s, Set<String> wordSet, Map<Integer, List<String>> dp, int i){
        if (i == s.length()){
           List<String> res = new ArrayList<>();
           res.add("");
           return res; 
        }
        if (dp.containsKey(i)){
            return dp.get(i);
        }
        List<String> res = new ArrayList<>();
        for (int j = i; j < s.length(); j++){
            String cur = s.substring(i, j + 1);
            if (wordSet.contains(cur)){
                List<String> wordList = dfs(s, wordSet, dp, j + 1);
                for (String str: wordList){
                    if (!str.equals("")){
                        res.add(cur + " " + str);
                    } else{
                        res.add(cur);
                    }
                    
                }
            }
        }
        dp.put(i, res);
        return res;
    }
}