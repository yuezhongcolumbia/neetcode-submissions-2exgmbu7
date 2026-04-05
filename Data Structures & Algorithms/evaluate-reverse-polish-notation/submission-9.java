class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens){
            if (str.equals("+")){
                int tmp = stack.pop() + stack.pop();
                stack.push(tmp);
            } else if (str.equals("-")){
                int right = stack.pop();
                int left = stack.pop();
                int tmp = left - right;
                stack.push(tmp);
            } else if (str.equals("/")){
                int right = stack.pop();
                int left = stack.pop();
                int tmp = left / right;
                stack.push(tmp);
            }else if(str.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
    
}
