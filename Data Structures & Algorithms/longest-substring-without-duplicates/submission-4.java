class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0;
        int ans = 0;
        HashSet<Character>set = new HashSet<>();
        for(int r=0; r< s.length();r++){
            while(l<r&&set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            ans = Math.max(ans, r-l+1);
            set.add(s.charAt(r));
        }
        return ans;
    }
}
