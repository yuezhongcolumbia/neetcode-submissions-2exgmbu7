class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer>map1 = new HashMap<>();
        HashMap<Character, Integer>map2 = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c,0)+1);
        }
        for (int j = 0; j< t.length();j++){
            char temp = t.charAt(j);
            if(!map1.containsKey(temp)||map1.get(temp)==0){
                return false;
            }
            map1.put(temp,map1.get(temp)-1);
        }
        return true;
    }
}
