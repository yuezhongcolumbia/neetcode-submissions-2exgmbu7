class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>curr = new ArrayList<>();
        backtrack(nums,curr,res);
        return res;
    }
    public void backtrack(int[]nums, List<Integer>curr, List<List<Integer>>res){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i =0; i<nums.length;i++){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                backtrack(nums,curr,res);
                curr.remove(curr.size()-1);
                
            }
        }
    }
}
