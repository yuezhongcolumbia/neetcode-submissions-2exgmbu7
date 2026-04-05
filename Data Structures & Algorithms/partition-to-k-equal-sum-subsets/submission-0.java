class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        boolean[]visited= new boolean[nums.length];
        for(int num:nums){
            sum+=num;
        }
        if(sum%k!=0){
            return false;
        }
        int targetSum = sum/k;
        return backtrack(nums,targetSum,0,k,0,visited);

    }
    private boolean backtrack(int[]nums, int targetSum,int index, int k, int curSum, boolean[]visited ){
        if(curSum>targetSum){
            return false;
        }
        if(k==0){
            return true;
        }
        if(curSum==targetSum){
            return backtrack(nums,targetSum,0,k-1,0,visited);
        }
    
        for(int i =index; i<nums.length; i++){
            if(!visited[i]){
                visited[i]=true;
                if(backtrack(nums,targetSum,i+1,k,curSum+nums[i],visited)){
                    return true;
                }
                visited[i]=false;
            }
        }
        return false;
    }
}