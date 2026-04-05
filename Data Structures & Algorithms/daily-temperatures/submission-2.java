class Solution {
    // obj:
    //     return for each day, number of days that is warmer than that day
    // impl:
    //     want to know the next greater element's index ---> mono Decreasing stack

    public int[] dailyTemperatures(int[] temperatures) {
        //state: monoStack, result
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                // previous day index = pop;
                int prevIdx = stack.pop();
                // update result
                res[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }
        return res;
    }
}
