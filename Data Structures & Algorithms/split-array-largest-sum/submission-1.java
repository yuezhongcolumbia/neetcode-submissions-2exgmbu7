class Solution {
    public int splitArray(int[] nums, int k) {
        int r = 0, l = 0, res = 0;
        for (int num: nums){
            r += num;
            res += num;
            l = Math.max(l, num);

            while (l <= r){
                int mid = l + (r - l) / 2;
                if (canSplit(nums, mid, k)){
                    r = mid - 1;
                    res = mid;
                } else {
                    l = mid + 1;
                }
            }
           
        }  
          return res;
    }
    public boolean canSplit(int[] nums, int largest, int k){
        int subArray = 1, curSum = 0;
        for (int num: nums){
            curSum += num;
            if (curSum > largest) {
                subArray ++;
                curSum = num;
            }
            if (subArray > k) {
                return false;
            }

        }
        return true;
    }
}