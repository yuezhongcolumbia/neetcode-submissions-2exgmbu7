class Solution {
    public List<Integer> partitionLabels(String s) {
        //build last occurence table
        int[] lastOccurance = new int[26];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            lastOccurance[c - 'a'] = i;
        }

        //second pass for partitioning
        int partitionStart = 0;
        int rightBound = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //expand the rightBound greedily, when we reach the rightBound, partition
            rightBound = Math.max(rightBound, lastOccurance[c - 'a']);
            if (i == rightBound){
                int len = rightBound - partitionStart + 1;
                res.add(len);
                partitionStart = rightBound + 1;
            }
        }
        return res;
    }
   
}
