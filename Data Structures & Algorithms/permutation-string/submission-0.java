class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[]map = new int[26];
        int[]map2 = new int[26];
        for(int i =0; i < s1.length(); i++){
            map[s1.charAt(i)-'a']++;
        }
        int l = 0;
        for(int r = 0; r<s2.length();r++){
            
            map2[s2.charAt(r)-'a']++;
             if((r-l+1)==s1.length()){
                if(Arrays.equals(map,map2)){
                    return true;
                }else{
                    map2[s2.charAt(l)-'a']--;
                    l++;

                }
             }
        }
        return false;
    }
}
