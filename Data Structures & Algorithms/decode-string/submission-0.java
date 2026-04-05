class Solution {
    // obj:
    //     1. nested structure with []
    //     2. how many nested
    //     3. single char
    // impl:
    //     1.什么时候push
    //         left bracket index, so that within certain range 

    //     2.什么时候pop
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int curCount = 0;
        StringBuilder curString = new StringBuilder();
        for (char c: s.toCharArray()){
            //left bracket, save previous decoded string, and reset it; save previous decoded digit, reset it
            if (c == '['){
                stringStack.push(curString.toString());
                countStack.push(curCount);
                curString = new StringBuilder();
                curCount = 0;
            }
            //digit, update decoded digit
                else if (Character.isDigit(c)){
                    curCount = curCount * 10 + (c - '0');
            }
            //right bracket, update res
                else if (c == ']'){
                    String temp = curString.toString();
                    curString = new StringBuilder(stringStack.pop());
                    int count = countStack.pop();
                    for (int i = 0; i < count; i++){
                        curString.append(temp);
                    }
            }
            //char, update decoded digit
                else{
                    curString.append(c);
            }
        }
        return curString.toString();
    }
}