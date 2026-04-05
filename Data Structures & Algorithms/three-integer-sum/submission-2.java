class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int first = 0;
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        while (first < n - 2){
            int firstNum = nums[first];
            int sumLeft = 0 - firstNum;
            int l = first + 1;
            int r = n - 1;
            while (l < r){
                int sum = nums[l] + nums[r];
                if (sum < sumLeft){
                    l++;
                } else if (sum > sumLeft){
                    r--;
                } else{
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(firstNum);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    res.add(triplet);
                    l++;
                    while (l < n && nums[l] == nums[l - 1]){
                        l++;
                    }
                }
            }
            int next = first;
            while(next < n - 2 && nums[next] == firstNum){
                next++;
            }
            first = next;
        }
        return res;
    }
}
