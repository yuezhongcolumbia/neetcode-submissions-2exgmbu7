class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]){
                //bottom
                int bottom = height[stack.pop()];
                if (!stack.isEmpty()){
                    //left and right wall height
                    int left = height[stack.peek()];
                    int right = height[i];
                    //width
                    int w = i - stack.peek() - 1;
                    //update ans
                    res += (Math.min(left, right) - bottom) * w;
                }
            }
            //push
            stack.push(i);
        }
        return res;
    }
}
