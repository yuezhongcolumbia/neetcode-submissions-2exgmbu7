class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagram = new HashMap<>();
        for (String str: strs){
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = Arrays.toString(strArr);
            anagram.putIfAbsent(key, new ArrayList<>());
            anagram.get(key).add(str);
        }
        return new ArrayList<>(anagram.values());
    }
}
