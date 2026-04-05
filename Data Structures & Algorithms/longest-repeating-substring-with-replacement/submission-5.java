class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> countS = new HashMap<>();
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++){
            char charR = s.charAt(r);
            countS.put(charR, countS.getOrDefault(charR, 0) + 1);
            int replace = r - l + 1 - Collections.max(countS.values());
            while (replace > k){
                char charL = s.charAt(l);
                countS.put(charL, countS.get(charL) - 1);
                l++;
                replace = r - l + 1 - Collections.max(countS.values());
            }
            res = Math.max(res, r- l + 1);
        }
        return res;
    }
}
