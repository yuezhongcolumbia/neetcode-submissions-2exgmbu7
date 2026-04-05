class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ana = new HashMap<>();
        for (String str: strs){
             int[] count = new int[26];
            for (char c: str.toCharArray()){
                count[c - 'a'] ++;
            }
            String key = Arrays.toString(count);
            ana.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(ana.values());
    }
}
