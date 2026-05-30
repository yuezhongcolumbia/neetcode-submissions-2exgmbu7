class Solution {
    List<String> path;
    List<List<String>> res;
    String s;
    public List<List<String>> partition(String s) {
        // 1.worst case n^2 * 2*n
        // 2. helper function to determine palindrom
        this. s = s;
        path = new ArrayList<>();
        res = new ArrayList<>();
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
            if (isPalindrome(cur)){
                path.add(cur);
                backtrack(end + 1);
                path.remove(path.size() - 1);
            }

        }
    }
    public boolean isPalindrome(String str){
        int l = 0;
        int r = str.length() - 1;
        while(l < r){
            if (str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
