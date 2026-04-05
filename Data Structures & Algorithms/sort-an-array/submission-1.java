class Solution {
    // do it in place
    //divide and conquor
    //time height of recursion stack is LogN, every layer the cost is O(N)
    //every layer extra space is temp->O(N), recursion stack space is O(logN);
    

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void mergeSort(int[] arr, int l, int r){
        // base
        if (l >= r) return;
        // get mid
        int m = (l + r)/2;
        // left half recursion
        // right half recursion
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, r);
        
    }
    public void merge(int[] arr, int l, int r){
        int m = (l + r) / 2;
        List<Integer> temp = new ArrayList<>();
        // i, j, starting from left and mid + 1
        int i = l, j = m + 1;
        while(i <= m && j <= r){
            if (arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }
        while(i <= m){
            temp.add(arr[i]);
            i++;
        }
        while(j <= r){
            temp.add(arr[j]);
            j++;
        }
        for (i = l ; i <= r; i++){
            arr[i] = temp.get(i - l);
        }
    }
}