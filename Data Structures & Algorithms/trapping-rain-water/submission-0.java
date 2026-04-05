class Solution {
    public int trap(int[] height) {
        int[]left = new int[height.length];
        int[]right = new int[height.length];
       
        int left_max = 0;
        int right_max=0;
        int result = 0;
        
        for(int i =right.length-1;i>=0; i --){
            right[i]=right_max;
            right_max = Math.max(right_max,height[i]);
        }
        for(int i =0; i< left.length; i ++){
            left[i] = left_max;
            left_max = Math.max(left_max,height[i]);
            
            result+=Math.max(0,Math.min(left[i],right[i])-height[i]);
        }
        return result;
    }
}
