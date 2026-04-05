class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int[]freq = new int[26];
        int l = 0;
        int max=0;
        
        for(int r = 0; r< s.length(); r++){
            char c = s.charAt(r);
            freq[c - 'A'] ++;
            max = Math.max(max, freq[c-'A']);
            if(r-l+1-max>k){
                char d = s.charAt(l);
                freq[d-'A']--;
                l++;
            }
            res = Math.max(r-l+1,res);

        }
        return res;
    }
}
