class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int idx = 0;
        for (int i = 1; i < arr.length; i++){
            if ( Math.abs(x - arr[i]) <= Math.abs(x - arr[idx])){
                idx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(arr[idx]);
        int l = idx - 1;
        int r = idx + 1;
        
        while(res.size() < k){
            if (l >= 0 && r < arr.length){
                if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])){
                    res.add(arr[l--]);
                } else {
                    res.add(arr[r++]);   
                }

            } else if (l >= 0 ){
                res.add(arr[l--]);
            } else if (r < arr.length){
                res.add(arr[r++]);  
            }
        }
        Collections.sort(res);
        return res;
    }
}