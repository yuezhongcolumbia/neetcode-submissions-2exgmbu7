class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        //traverse finding what is the index of the first smaller height on the left
        for (int i = 0;  i < n; i++){
            leftSmaller[i] = -1;
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                leftSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        //traverse finding what is the index of the first smaller height on the right
        for (int i = n - 1; i >= 0; i--){
            rightSmaller[i] = n;
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                rightSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        //calculate
        int res = 0;
        for (int i = 0; i < n; i++){
            int left = leftSmaller[i] + 1;
            int right = rightSmaller[i] - 1;
            res = Math.max(res, heights[i] * (right - left + 1));
        }
        return res;
    }
}
