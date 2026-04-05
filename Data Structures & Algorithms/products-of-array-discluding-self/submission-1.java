class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[]right = new int[nums.length];
        
        int left = 1;
        int[]res = new int[nums.length];
        for(int i = nums.length -1;i>=0;i--){
            if(i ==nums.length -1){
                right[i]=1;
            }else{
                right[i]= nums[i+1]*right[i+1];
            }
        }
        for(int i =0; i<nums.length;i++){
            if(i==0){
                res[i]=right[i];
            }else{
                left = left*nums[i-1];
                res[i]=left*right[i];
            }
        }
        return res;
    }
}  
