class Solution {
    // 1. we need to count frequency of each alphebet in each word:
    //     int[26]
    // 2. we need to categorize
    //     hashmap
    // time: iterate very char of every word on the list, and the cost is O(1);
    // space: hashmap O(N), res O(N), count
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagram = new HashMap<>();
       
        for (String str: strs){
            int[] count = new int[26];
            for (char c: str.toCharArray()){
                count[c - 'a'] ++;
            }
            //
            String key = Arrays.toString(count);
            anagram.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        // for (Map.Entry<int[], List<String>> entry: anagram.entrySet()){
        //     res.add(entry.getValue());
        // }

        return new ArrayList<>(anagram.values());
    }
}
