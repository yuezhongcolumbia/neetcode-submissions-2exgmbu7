class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        if (s.length() < t.length()){
            return "";
        }
        for (char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int l = 0, satisfy = 0, require = countT.size(); ;
        int windowLen = Integer.MAX_VALUE;
        int windowLeft = -1;
        for (int r = 0; r < s.length(); r++){
            char charR = s.charAt(r);
            countS.put(charR, countS.getOrDefault(charR, 0) + 1);
            if (countT.containsKey(charR) && countS.get(charR) == countT.get(charR)){
                satisfy++;
            }
            while (satisfy == require){
                if (r - l + 1 < windowLen){
                   windowLen = r - l + 1;
                    windowLeft = l; 
                }
                
                char charL = s.charAt(l);
                countS.put(charL, countS.get(charL) - 1);
                l++;
                if (countT.containsKey(charL) && (countT.get(charL) > countS.get(charL))){
                    satisfy --;
                }
            }
        }
        return windowLen != Integer.MAX_VALUE ? s.substring(windowLeft, windowLeft + windowLen) : "";
    }
}
