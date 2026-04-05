class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;
        int l=0;
        int r= heights.length-1;
        while(l<r){
            int area = Math.min(heights[l],heights[r])*(r-l);
            ans = Math.max(area, ans);
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
            
        }
        return ans;
    }
}
