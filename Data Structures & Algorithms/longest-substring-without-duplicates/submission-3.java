class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        HashSet<Character>set = new HashSet<>();
        int l = 0;
        int ans = 0;
        for(int r=0; r<s.length(); r++ ){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(r-l+1, ans);

        }
        return ans;
    }
}
