class Solution {
    Map<Integer, Integer> dp;
    String s;
    public int numDecodings(String s) {
        this.s = s;
        dp = new HashMap<>();
        return dfs(0);
        
    }
    public int dfs(int i){
        if (i == s.length()){
            return 1;
        }
        if (dp.containsKey(i)){
            return dp.get(i);
        }
        if (s.charAt(i) == '0') return 0;
        int res = dfs(i + 1);
        if (i + 1 < s.length() && (Integer.valueOf(s.substring(i, i + 2)) >= 10 &&  Integer.valueOf(s.substring(i, i + 2)) <= 26)){
            res += dfs(i + 2);
        }
        dp.put(i, res);
        return res;
        
        
    }
}
