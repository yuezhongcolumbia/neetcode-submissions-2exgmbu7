class Solution {
    public int minimizeMax(int[] nums, int p) {
    //     p=0 -> 0
    //     1 , 3, 9, 5 p = 1 -> return 2,  just return the pair with least diff
    //                 p = 2 -> return 4
        
    //     -> return the p smallest difference in pairs. pairs cannot reuse index

       
    //    sort
    //    answer can only be difference between neighbors.

    //    why set r = nums[nums.length - 1] - nums[0]? 最小diff是 1， 最大是r
    //    why mid is the threshold? 只是为了缩边界，缩到最后符合条件的就是最优解
    //    what is valid? 在整体nums里 能凑够 p 个 diff 小于threshhold 的pair.
    if (p == 0) return 0;
    Arrays.sort(nums);
    int n = nums.length;
    int l = 0, r = nums[n - 1] - nums[0];
    int res = -1;
    while (l <= r){
        int m = (l + r) >> 1;
        if (isValid(nums, m, p)){
            res = m;
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    return res;

    }
    public boolean isValid(int[] nums, int threshold, int p){
        int count = 0;
        int i = 0;
        int n = nums.length;
        while (i < n - 1){
            if (Math.abs(nums[i] - nums[i + 1]) <=  threshold){
                count++;
                i+=2;
            } else {
                i++;
            }
            if (count == p) return true;
        }
       return false; 
    }
    
}