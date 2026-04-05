class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int pivot = 0;
        for (int i = 0; i < arr.length; i++){
            if (Math.abs(arr[i] -  x) < Math.abs(arr[pivot]- x)){
                pivot = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(arr[pivot]);
        int l = pivot - 1;
            int r = pivot + 1;
        while (res.size() < k){
            
            if (l >= 0 && r < n){
                if (Math.abs(arr[l]- x) <= Math.abs(arr[r]- x)){
                    res.add(arr[l]);
                    l--;
                    continue;
                } else {
                    res.add(arr[r]);
                    r++;
                    continue;
                }
            } else if (l < 0 && r < n) {
                res.add(arr[r]);
                r++;
                continue;
            } else if (l >=0 && r >= n){
                res.add(arr[l]);
                l--;
                continue;
            }

        }
        Collections.sort(res);
        return res;
    }
}