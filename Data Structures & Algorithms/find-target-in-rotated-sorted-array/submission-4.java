class Solution {
    public int search(int[] nums, int target) {
        int arrayLength = nums.length;
        int left = 0;
        int right = arrayLength - 1;

        // Binary search with rotation handling
        while (left < right) {
            int mid = (left + right) >> 1;  // Equivalent to (left + right) / 2
            if (nums[mid] == target){
                return mid;
            }
            // Check if the left half is sorted
            if (nums[0] <= nums[mid]) {
                // Target is in the sorted left half
                if (nums[0] <= target && target <= nums[mid]) {
                    right = mid - 1;  // Search in left half
                } else {
                    left = mid + 1;  // Search in right half
                }
            } else {
                // The right half must be sorted
                // Target is in the sorted right half
                if (nums[mid] < target && target <= nums[arrayLength - 1]) {
                    left = mid + 1;  // Search in right half
                } else {
                    right = mid -1;  // Search in left half
                }
            }
        }

        // Check if the element at the final position is the target
        return nums[left] == target ? left : -1;
    }
}
