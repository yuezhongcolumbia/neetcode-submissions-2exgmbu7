class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operator = Set.of("+", "-", "*", "/");
        for (String s: tokens){
            if (operator.contains(s)){
                int right = Integer.valueOf(stack.pop());
                int left = Integer.valueOf(stack.pop());
                int cur = 0;
                if (s.equals("+")){
                
                    cur = left + right;
                    
                } else if (s.equals("-")) {
                
                    cur = left - right;
                
                } else if (s.equals("*")){
                
                    cur = left * right;
                
                } else if (s.equals("/")){
                
                    cur = left / right;
                }
                stack.push(String.valueOf(cur));
            } else {
                stack.push(s);
            }
            
        }
        return Integer.valueOf(stack.peek());
    }
}
