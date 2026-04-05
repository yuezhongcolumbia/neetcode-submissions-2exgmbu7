class Solution {
    // obj:
    //     1. return the elements that remain
    //     2. figure out collision and remain element
    //     3. only opposite sign collide, same dont

    // impl:
    //     1. what DSA?
    //         a. dp?
    //             1. it returns a array
    //             2. there isnt much flexibility between choices, thus no recalculation of subproblems
    //             3. maybe a recursion will do
    //         b. stack?
    //             1. the negative sign always collide with near left positive sign, like brackets
    //             2. so How?
    //                 1. when positive push into stack
    //                 2. when negative:
    //                     a.if empty, put into res continue
    //                     b.if collision is negative, keep popping, if positive, push back, if 0
    //                         1. how to implememnt? while?

    //                 3.what about the rest of the stack, how to put them into return?
    //                     1.
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a: asteroids){
            boolean alive = true;
            //collision logic
            while (!stack.isEmpty() && stack.peek() > 0 && alive && a < 0){
                int left = Math.abs(stack.peek());
                int right = Math.abs(a);
                if (left > right){
                    alive = false;
                } else if (left == right){
                    stack.pop();
                    alive = false;
                } else {
                    stack.pop();
                }
            }
            if (alive){
                stack.push(a);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
        
    }
}