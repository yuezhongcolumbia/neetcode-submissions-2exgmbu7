class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        Map<Character, List<String>>map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList("a","b","c")));
        map.put('3', new ArrayList<>(Arrays.asList("d","e","f")));
        map.put('4', new ArrayList<>(Arrays.asList("g","h","i")));
        map.put('5', new ArrayList<>(Arrays.asList("j","k","l")));
        map.put('6', new ArrayList<>(Arrays.asList("m","n","o")));
        map.put('7', new ArrayList<>(Arrays.asList("p","q","r","s")));
        map.put('8', new ArrayList<>(Arrays.asList("t","u","v")));
        map.put('9', new ArrayList<>(Arrays.asList("w","x","y","z")));

        List<String>res = new ArrayList<>();
        StringBuilder curr= new StringBuilder();

        backtrack(map,digits,0,curr, res);
        
        return res;

    }

    public void backtrack(Map<Character, List<String>> map,String digits, int i,StringBuilder curr, List<String>res){
        if(curr.length()==digits.length()){
            res.add(curr.toString());
            return;
        }
        char c = digits.charAt(i);
        List<String>char_list = map.get(c);
        for(int j =0; j< char_list.size();j++){
            curr.append(char_list.get(j));
            backtrack(map, digits, i+1,curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
