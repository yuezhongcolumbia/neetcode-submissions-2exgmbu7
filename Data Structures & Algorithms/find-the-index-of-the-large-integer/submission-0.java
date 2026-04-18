/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    // 1. array not sorted, all the integers are equal
    // 2. compareSub(l, r ,x ,y) ->-1, 0 ,1, compare sum of subarray[l, r], [x, y]
    // 3. find the largest integer index

    // 3,3,10,3
    // 3,3,3,3

    // 3,3,3,3,3

    // what is the characterisitic of the subarray sum that contains largest integer?
    // // it leads the biggest jump of prefixSum element.

    // // can we use prefixSum?
    // // pointless because doesnt sync well with compareSub, of course sum[l,r] always > sum[x, y]


    // as a subarray itself, the target always is larger than other subarray with size 1
    // but how can we shrink the range to subarray to one？

    
    // how can we utilize the compareSub? through comparing an element left subarray sums and right subarray sums?
    // what is the characteristics of the target left 



    // what does it mean 20 times only?
    // means it cannot be O(n)


    public int getIndex(ArrayReader reader) {
        int l = 0, r = reader.length() - 1;
        
        while (l <= r){
            int m = (l + r) >> 1;
            int curLen = r - l + 1;
            if (curLen % 2 == 0){
                int compRes = reader.compareSub(l, m, m + 1, r);
                if (compRes == 1){
                    r = m;
                    
                } else {
                    l = m + 1;
                }
            } else {
                if (curLen == 1) return m;
                int compRes = reader.compareSub(l, m - 1, m + 1, r);
                if (compRes == 0){
                    return m;
                } else if (compRes == 1){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
