class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>dic = new HashMap<>();
        for(String s: strs){
            int[]freq = new int[26];
            for(char c: s.toCharArray()){
                freq[c-'a']++;
            }
            String key = Arrays.toString(freq);
            if(!dic.containsKey(key)){
                dic.put(key,new ArrayList<>());
            }
            dic.get(key).add(s);
        }
        return new ArrayList<>(dic.values());
    }
}
