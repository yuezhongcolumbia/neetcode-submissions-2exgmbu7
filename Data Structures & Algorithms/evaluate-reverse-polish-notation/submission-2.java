class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer>deque = new ArrayDeque<>();
        for(String s:tokens){
            if(s.equals("+")){
                int a = deque.pop();
                int b = deque.pop();
                deque.push(a+b);
            }else if(s.equals("-")){
                int a = deque.pop();
                int b = deque.pop();
                deque.push(b-a);
            }else if(s.equals("/")){
                int a = deque.pop();
                int b = deque.pop();
                deque.push(b/a);
            }else if(s.equals("*")){
                int a = deque.pop();
                int b = deque.pop();
                deque.push(a*b);
            }else{
                deque.push(Integer.parseInt(s));
            }
        }
        return deque.peek();
    }
}
