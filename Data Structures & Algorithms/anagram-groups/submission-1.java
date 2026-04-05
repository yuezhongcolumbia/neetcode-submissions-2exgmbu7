class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>>result = new HashMap<>();
        for(int i =0; i<strs.length;i++){
            int[]count = new int[26];
            for(char c: strs[i].toCharArray()){
                count[c-'a'] +=1;
            }

            String mykey= Arrays.toString(count);
            if(!result.containsKey(mykey)){
                result.put(mykey, new ArrayList<String>());
            }
            result.get(mykey).add(strs[i]);
        }
        return new ArrayList<>(result.values());
    }
}
