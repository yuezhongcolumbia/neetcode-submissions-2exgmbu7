class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target,0,list,res);
        return res;

    }

    private static void backtrack(int[]nums, int i , int target, int sum,List<Integer>list, List<List<Integer>>res){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || i == nums.length){
            return;
        }

        list.add(nums[i]);
        sum+= nums[i];
        backtrack(nums,i+1,target,sum,list,res);

        int temp = nums[i];
        list.remove(list.size()-1);
        while(i+1<=nums.length-1 &&nums[i+1]==temp ){
            i++;
        }
        sum-=nums[i];
        backtrack(nums,i+1,target,sum,list,res);


    }
}
