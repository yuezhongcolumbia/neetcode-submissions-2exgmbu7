class Solution {
    public int trap(int[] height) {
        int[]left = new int[height.length];
        int[]right = new int[height.length];
       
        int left_max = 0;
        int right_max=0;
        int result = 0;
        
        for(int i =0; i<height.length; i ++){
            int j = height.length-1-i;
            left[i]=left_max;
            right[j]=right_max;
            left_max=Math.max(left_max,height[i]);
            right_max = Math.max(right_max, height[j]);
        }
        for(int i =0; i <height.length; i++){
            result+=Math.max(0, Math.min(left[i],right[i])-height[i]);
        }
        return result;
    }
}
