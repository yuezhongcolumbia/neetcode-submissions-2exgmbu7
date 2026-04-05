class Solution {
    public boolean isValid(String s) {
        Map<Character,Character>map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character>stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char left = stack.pop();
                    if(left!=map.get(c)){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
