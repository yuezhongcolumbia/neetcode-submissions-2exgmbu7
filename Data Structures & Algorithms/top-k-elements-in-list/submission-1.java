class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>count = new HashMap<>();
        for(int i: nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        List<Integer>[]freq = new List[nums.length+1];
        for(int i = 0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer>e:count.entrySet()){
            freq[e.getValue()].add(e.getKey());
        }
        int[]result = new int[k];
        int index = 0;
        for(int j = freq.length-1; j>=0; j--){
            if(index==k){
                return result;
            }else{
               for(int m: freq[j]){
                result[index]=m;
                index++;
                if(index == k){
                    return result;
                }
               }
               
            }
            
        }
        return result;


    }

}
