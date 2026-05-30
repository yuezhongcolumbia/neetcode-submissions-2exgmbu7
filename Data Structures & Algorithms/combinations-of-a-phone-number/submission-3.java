class Solution {
    List<String> res;
    String digits;
    StringBuilder path;
    Map<Character, List<Character>> map;
    public List<String> letterCombinations(String digits) {
       if (digits.length() == 0)return new ArrayList<>();
       res =  new ArrayList<>();
       this.digits = digits;
       path = new StringBuilder();
       map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        backtrack(0);
        return res;

    }
    public void backtrack(int idx){
        if (idx == digits.length()){
            res.add(new String(path));
            return;
        }
        for(char next: map.get(digits.charAt(idx))){
            path.append(next);
            backtrack(idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
        return;
    }
}
