class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c: s.toCharArray()){
            set.add(c);
        }   
        
        for (char c: set){
            int count = 0;
            int l = 0;
            for (int r = 0; r < s.length(); r++){
                if (s.charAt(r) == c){
                    count ++;
                }
                while (r - l + 1 - count > k){
                    if (s.charAt(l) == c){
                        count --;
                    }
                    l++;
                }
                res = Math.max(r- l + 1, res );
            }
        }
        return res;
    }
}
