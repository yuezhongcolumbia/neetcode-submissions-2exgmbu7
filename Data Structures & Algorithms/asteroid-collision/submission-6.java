class Solution {
    // impl:
    //     1. stack:
    //         1. push(same sign as peek)
    //         2. pop(opposite sign as peek and not empty)
    //             1. compare abs between cur and pop, update cur
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast: asteroids){
            if (ast < 0){
                // if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < 0) ){
                //     stack.push(ast);
                // }
                int cur = ast;
                while (!stack.isEmpty() && cur < 0 && stack.peek() > 0){
                    //
                    int peek = stack.peek();
                    //compare and update cur and decide whether to pop
                    if (Math.abs(cur) == peek){
                        cur = 0;
                        stack.pop();
                    } else if (Math.abs(cur) > peek){
                        stack.pop();
                    } else {
                        cur = 0;
                    }
                }    
                if ( cur != 0){
                        stack.push(cur);
                }
                
            } else {
                stack.push(ast);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}