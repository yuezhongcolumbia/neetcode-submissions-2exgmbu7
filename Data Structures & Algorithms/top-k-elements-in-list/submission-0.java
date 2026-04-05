class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>count = new HashMap<>();
        for(int num: nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        List<Integer>[]freq = new List[nums.length+1];
        for(int i =0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer>entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[]result = new int[k];
        int index = 0;
        for(int j = freq.length-1; j>0; j--){
            for(int m: freq[j]){
                result[index] = m;
                index++;
                if(index == k){
                    return result;
                }
            }
        }
        return result;
    }
}
