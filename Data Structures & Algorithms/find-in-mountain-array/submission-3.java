/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0;
        int length = mountainArr.length();
        int r = length - 1;
        int peak = 0;
        //peak
        while (l <= r){
            int m = (l + r) / 2;
            int mid = mountainArr.get(m);
            int left = mountainArr.get(m - 1);
            int right = mountainArr.get(m + 1);
            if (mid > left && mid < right) {
                l = m + 1;
            } else if (mid < left && mid > right) {
                r = m - 1;
            } else {
                peak = m;
                break;
            }

        }
        //search left
        l = 0;
        r = peak;
        while (l <= r){
            int m = (l + r) / 2;
            int mid = mountainArr.get(m);
            if (target == mid){
                return m;
            }
            if (target < mid){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        //search right
        l = peak ;
        r = length - 1;
        while (l <= r){
            int m = (l + r) / 2;
            System.out.print(m);
            int mid = mountainArr.get(m);
            if (target == mid){
                return m;
            }
            if (target > mid) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;

    }
}