class Solution {
    // 1. sort
    // 2. cant have duplicate in the same level
    // state:
    //     path, set
    // choices:
    //     cannot have duplicate
    List<List<Integer>> res;
    List<Integer> valid;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        valid = new ArrayList<>();
        Arrays.sort(nums);
        for (int num: nums){
            valid.add(num);
        }
        List<Integer> path = new ArrayList<>();
        backtrack(nums, path);
        return res;
    }
    public void backtrack(int[] nums, List<Integer> path){
        int n = nums.length;
        if (path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < valid.size(); i++){
            if (i + 1 < valid.size() && valid.get(i) == valid.get(i + 1)) continue;
            int val = valid.get(i);
            path.add(val);
            valid.remove(i);
            
            backtrack(nums, path);
            path.remove(path.size() - 1);
            valid.add(i, val);
        }
    }

}