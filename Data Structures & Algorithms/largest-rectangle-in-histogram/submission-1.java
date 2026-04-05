// obj:
//     find the span.to the left and right.
// impl:
//     how to find leftLower? increasing monostack, from left to right
class Solution {
   
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];

        
        
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--){
            leftMost[i] = -1;
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                leftMost[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for(int i = 0; i < n; i++){
            rightMost[i] = n;
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                rightMost[stack.pop()] = i;
            }
            stack.push(i);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, heights[i] * (rightMost[i] - leftMost[i] - 1));
        }
        return res;
    }
}
