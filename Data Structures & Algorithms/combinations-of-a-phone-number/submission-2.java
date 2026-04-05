class Solution {
    private Map<Integer, List<Character>>map;
        
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        map = new HashMap<>();
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d','e','f'));
        map.put(4, Arrays.asList('g','h','i'));
        map.put(5, Arrays.asList('j','k','l'));
        map.put(6, Arrays.asList('m','n','o'));
        map.put(7, Arrays.asList('p','q','r','s'));
        map.put(8, Arrays.asList('t','u','v'));
        map.put(9, Arrays.asList('w','x','y','z'));
        List<String>res = new ArrayList<>();
        List<Character>path = new ArrayList<>();
        backtrack(digits,0,path,res);
        return res;
        
        
    }
    private void backtrack(String digits, int index, List<Character>path,List<String>res){
        if(index==digits.length()){
            StringBuilder copy = new StringBuilder();
            for(char c: path){
                copy.append(c);
            }
            res.add(copy.toString());
            return;
        }

        for(char c: map.get(digits.charAt(index)-'0')){
            path.add(c);
            backtrack(digits, index+1, path, res);
            path.remove(path.size()-1);
        }
        return;



    }
}
