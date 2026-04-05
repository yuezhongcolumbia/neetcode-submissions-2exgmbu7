class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>curr = new ArrayList<>();
        backtrack(nums,0,curr,res);
        return res;
    }
    public void backtrack(int[]nums, int i, List<Integer>curr, List<List<Integer>>res){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        backtrack(nums,i+1,curr,res);
        curr.remove(curr.size()-1);
        while(i<=nums.length-2 && nums[i+1]==nums[i]){
            i++;
        }
        backtrack(nums,i+1,curr,res);


    }
}
