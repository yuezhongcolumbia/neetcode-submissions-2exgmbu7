class Solution {
    // obj:
    //     1. need to recall left operand
    //     2. need to remember right operand
    // impl:
    //     1. always comes in pairs, maybe it work similar with parenthese problem
    //         with open and close
    //     2. this case there is no invalid parentheses, it always closes.
    public int evalRPN(String[] tokens) {
        //stack
        Stack<Integer> stack = new Stack<>();
        Set<String> operator = new HashSet<>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");

        for (int i = 0; i < tokens.length; i++){
            if (!operator.contains(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                //pop recent 2
                int right = stack.pop();
                int left = stack.pop();
                String cur = tokens[i];
                int res = 0;
                //calculate
                if (cur.equals("+")){
                    res = left + right;
                }else if(cur.equals("-")){
                    res = left - right;
                }else if(cur.equals("*")){
                     res = left * right;
                }else if(cur.equals("/")){
                    res = left / right;
                }
                //pushback
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
