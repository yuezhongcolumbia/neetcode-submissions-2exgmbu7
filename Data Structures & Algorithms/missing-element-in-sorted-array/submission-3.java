class Solution {
    public int missingElement(int[] nums, int k) {
    //    1.ascending order sorted
    //    2. integer
    //    3. unique

    //    0,1,2,3, 4
    //    4,6,9,12,13 k = 3 -> 10

    //    locate the left nearest element.
    //    so the number of missing integer at index i = nums[i] - nums[0] - i
    //    we want to find the last idx that missing[i] < k

    //     while(l < r){
    //         missing = ....
    //         if (missing < k){
    //             l = m
    //         }else {
    //             r= m - 1
    //         }
    //     }

    //     how much to increment?
    //     k - missing
        int l = 0, r = nums.length - 1;
        while (l < r){
            int m = r - (r - l) / 2;
            int missing = nums[m] - nums[0] - m;
            if (missing < k){
                l = m;
            } else {
                r = m - 1;
            }
        }
        int gap = k - (nums[l] - nums[0] - l);
        return nums[l] + gap;

      

    }
}
