class Solution {
    // obj:
    //     k[string] means repeating string k times
    // impl:
    //     nested structure -> stack:
    // variant:
    //     1.stack
    //     2.stackString
    //     3.cur
    // transition:
    //     1.stack:
    //         a.push:
    //           any number  
    //         b.pull:
    //             right bracket
        
    //     2.stackString:
    //         when left bracket, push cur
    //         when right bracket, pop
           
    //     3.cur :
    //         char, cur append(char)
    //         when left bracket, after push to stackString, cur reset
    //         when right bracket, repeat, cur -> stackString.pop().append(cur)
    public String decodeString(String s) {
        //initiate
        int k = 0;
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        for (char c: s.toCharArray()){
            if (Character.isDigit(c)){
                k = k * 10 + (c - '0');
            } else if (Character.isLetter(c)){
                cur.append(c);
            } else if (c == '['){
                stack.push(k);
                stringStack.push(cur.toString());
                cur = new StringBuilder();
                k = 0;
            } else {
                //cur repeat stack.pop()time, if empty just one
               int count = !stack.isEmpty() ? stack.pop() : 1;
               String temp = cur.toString();
               for (int i = 0; i < count - 1; i++){
                cur.append(temp);
               }
                // cur -> stackString.append(cur)
                cur = new StringBuilder(stringStack.pop() + cur.toString());
                
            }
        }
        return cur.toString();
    }
}