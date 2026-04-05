class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if (t.length() > s.length()){
            return "";
        }
        //initialize
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        int l = 0;
        int resLen = Integer.MAX_VALUE;
        int[] resIdx = {-1, -1};
        int need = t.length(), have = 0;
        for (char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        for (int r = 0; r < s.length(); r++){
            //update ds and constraints
            char charR = s.charAt(r);
            countS.put(charR, countS.getOrDefault(charR, 0) + 1);

            if (countT.containsKey(charR) && countT.get(charR) >= countS.get(charR)){
                have++;
            }
            //shrinking valid window
            while (need == have){
                //update ans
                if ((r - l + 1) < resLen) {
                    resIdx[0] = l;
                    resIdx[1] = r;
                    resLen = r - l + 1; 
                }
                //move window to left, update ds, l and constraints
                char charL = s.charAt(l);
                countS.put(charL, countS.get(charL) - 1);
                if (countT.containsKey(charL) && countT.get(charL) > countS.get(charL)){
                    have--;
                }
                l++;
            }
            
        }
        return resLen != Integer.MAX_VALUE ? s.substring(resIdx[0], resIdx[1] + 1) : "";
    }
}
