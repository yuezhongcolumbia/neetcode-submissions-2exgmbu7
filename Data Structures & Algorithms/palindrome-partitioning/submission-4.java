class Solution {
    List<String> path;
    List<List<String>> res;
    String s;
    boolean[][] memo;
    public List<List<String>> partition(String s) {
        // 1.worst case n^2 * 2*n
        // 2. helper function to determine palindrom
        this. s = s;
        path = new ArrayList<>();
        res = new ArrayList<>();
        int n = s.length();
        memo = new boolean[n][n];
        for (int len = 1; len <= n; len++){
            for (int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)){
                    if (len <= 3){
                        memo[i][j] = true;
                    } else{
                        memo[i][j] = memo[i + 1][j - 1];
                    }
                }
            }
        }
        backtrack(0);
        return res;
    }
    public void backtrack(int start){
        if (start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end < s.length(); end++){
            String cur = s.substring(start, end + 1);
            if (memo[start][end]){
                path.add(cur);
                backtrack(end + 1);
                path.remove(path.size() - 1);
            }

        }
    }
    // public boolean isPalindrome(String str){
    //     int l = 0;
    //     int r = str.length() - 1;
    //     while(l < r){
    //         if (str.charAt(l) == str.charAt(r)){
    //             l++;
    //             r--;
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
