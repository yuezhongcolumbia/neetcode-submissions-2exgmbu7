class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        backtrack(nums,0,target,0,list,res);
        return res;


    
    }

    private static void backtrack(int[]nums, int i, int target, int sum, List<Integer>list, List<List<Integer>>res){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || i >nums.length-1){
            return;
        }
        list.add(nums[i]);
        sum+=nums[i];
        backtrack(nums,i,target,sum,list,res);

        list.remove(list.size()-1);
        sum-=nums[i];
        i +=1;
        backtrack(nums,i,target,sum,list,res);



    }
}
