class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int l = 0, res = 0;
        int maxRep = 0;
        for (int r = 0; r < s.length(); r++){
            char charR = s.charAt(r);
            count.put(charR, count.getOrDefault(charR, 0) + 1);
            maxRep = Math.max(maxRep, count.get(charR));
            while (r - l + 1 - maxRep > k){
                char charL = s.charAt(l);
                count.put(charL, count.get(charL) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
