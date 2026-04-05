class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]>stack = new Stack<>();
        int[]ans = new int[temperatures.length];

        for(int i =0; i<temperatures.length;i++){
            int curr_temp = temperatures[i];
        
            while(!stack.isEmpty()&&curr_temp>stack.peek()[0]){
                int prev = stack.peek()[1];
                ans[prev]=i-prev;
                stack.pop();
            }
            stack.push(new int[]{curr_temp,i});
            
        }
    return ans;
    }
}
