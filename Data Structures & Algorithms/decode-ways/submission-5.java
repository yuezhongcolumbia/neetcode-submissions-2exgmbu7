class Solution {
    public int numDecodings(String s) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(s, dp);
    }
    public int dfs(String curr, Map<String, Integer> dp){
        if ((curr.length() == 1 && Integer.valueOf(curr) != 0) || curr.length() == 0){
            return 1;
        }
        if (dp.containsKey(curr)){
            return dp.get(curr);
        }
        int res = 0;
        for(int end = 1; end <= 2 && end <= curr.length(); end++){
            String firstHalf = curr.substring(0, end);
            String secondHalf = (firstHalf.length() == curr.length() ? "" : curr.substring(end));
            if (Integer.valueOf(firstHalf) < 1 ||
               Integer.valueOf(firstHalf) > 26 || 
               (secondHalf.length() >=1 && secondHalf.charAt(0) == '0' ) || 
               firstHalf.charAt(0) == '0'){
                    continue;
            }
            res += dfs(secondHalf, dp);
        } 
        dp.put(curr, res);
        return res;
    }
}
