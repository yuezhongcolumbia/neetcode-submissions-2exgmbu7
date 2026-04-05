class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++){
            char charR = s.charAt(r);
            count.put(charR, count.getOrDefault(charR, 0) + 1);
            while (count.get(charR) > 1){
                char charL = s.charAt(l);
                count.put(charL, count.get(charL) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
