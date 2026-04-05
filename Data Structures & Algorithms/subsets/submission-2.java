class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        backtrack(nums,0,path,res);
        return res;

    }
    private void backtrack(int[]nums, int index, List<Integer>path,List<List<Integer>>res){
        int n = nums.length;
        if(index == n){
            List<Integer>copy = new ArrayList<>();
            for(int i: path){
                copy.add(i);
            }
            res.add(copy);
            return;
        }
        path.add(nums[index]);
        backtrack(nums,index+1,path,res);
        path.remove(path.size()-1);
        backtrack(nums,index+1,path,res);
        return;
    }
}
