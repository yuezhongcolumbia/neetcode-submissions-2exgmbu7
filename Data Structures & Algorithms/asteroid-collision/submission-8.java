class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // 1. compare sign with peek() and current asteroid:
        //     a. if same || empty(), push
        //     b. if dif:
        //         1. cur is bigger, keep popping, until empty() || same direction with peek() || peek() is bigger
        //         2. cur is same, pop
        //         3. cur is smaller, continue
        Stack<Integer> stack = new Stack<>();
        for (int ast: asteroids){
            if (ast < 0){
                boolean survive = true;
                while (!stack.isEmpty() && stack.peek() > 0 ){
                    if (stack.peek() == Math.abs(ast)){
                        stack.pop();
                        survive = false;
                        break;
                        //we want to continue
                    } else if (stack.peek() < Math.abs(ast)){
                        stack.pop();
                        survive = true;
                        //we still want to push
                    } else{
                        survive = false;
                        break;
                        // we want to continue
                    }
                }
                if (survive){
                    stack.push(ast);
                }
                

            } else {
                stack.push(ast);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}