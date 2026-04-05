class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if (s1.length() > s2.length()) {
            return false;
        }
        int match = 0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
           
        }
        for(int i = 0; i < 26; i++){
            if (count1[i] == count2[i]){
                match++;
            }
        }
        if (match == 26) return true;
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++){
            int index = s2.charAt(r) - 'a';
            count2[index]++;
            if (count1[index] == count2[index]){
                match++;
            } else if(count1[index] + 1 == count2[index]){
                match--;
            }
            index = s2.charAt(l) - 'a';
            count2[index]--;
            if (count1[index] == count2[index]){
                match++;
            } else if(count1[index] - 1 == count2[index]){
                match--;
            }
            l++;
            if (match == 26) return true;
        }
        return false;

    }
}
