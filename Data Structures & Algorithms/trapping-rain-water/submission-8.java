class Solution {
    public int trap(int[] height) {
        int l = 0;
        int n = height.length;
        int r = n - 1;
        int leftMax = height[0];
        int rightMax = height[r];
        int res = 0;
        while (l < r){
            if (leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            }   else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
