class Solution {
    public boolean checkValidString(String s) {
      Stack<Integer>stack1 = new Stack<>();
      Stack<Integer>stack2 = new Stack<>();
    for(int i =0; i<s.length();i++){
         char c = s.charAt(i);
         if(c=='('){
            stack1.push(i);
         }else if( c=='*'){
            stack2.push(i);
         }else{
            if(stack1.isEmpty()&&stack2.isEmpty()){
                return false;
            }
            
            if(stack1.isEmpty() && !stack2.isEmpty()){
                stack2.pop();
            }
            else{
                stack1.pop();
            }
         }
    }
    if(!stack1.isEmpty()&&stack2.isEmpty()){
        return false;
    }
    while(!stack1.isEmpty()&&!stack2.isEmpty()){
        if(stack1.pop()>stack2.pop()){
            return false;
        }
    }
    return stack1.isEmpty();

    }
}
