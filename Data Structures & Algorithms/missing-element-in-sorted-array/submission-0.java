class Solution {
    public int missingElement(int[] nums, int k) {
        // 1.problem:
        //     unique
        //     sorted ascending order
        //     integer
        //     kth missing number
        // 2. example : 2,5,6,8 k=1 -> 3;    k =3 -> 7
        // 3. numbers are in these gaps, first we need to which gap.
        //     3a. 0, 2, 0, 1  -> 0,0,2,2,3, we find the left nearest index, meaning at that index, there will be gap
        //     3b. the gap is prefixSum[idx + 1] - prefixSum [idx], ans is nums[idx] + gap
        // 4. dry run:
    //         4,7,9,10
    //     gap 0,2,1,0;
    // prefixSum 0,0,2,3,3; k=1
    // idx = 1, increment = 1 - 0 = 1;
    


        int n = nums.length;
        int[] gap = new int[n];
        gap[0] = 0;
        for (int i = 1; i < nums.length; i++){
            int next = nums[i - 1] + 1;
            gap[i] = nums[i] - next;
        }
        int[] prefixSum = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + gap[i];
        }
        int l = 1, r = n;
        int idx = -1;
        while (l <= r){
            int m = (l + r) >> 1;
            if (prefixSum[m] < k){
                idx = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int increment = k - prefixSum[idx];
        return nums[idx - 1] + increment;
    }
}
