class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]>list = Arrays.asList(intervals);
        list.sort((a,b)->{return a[0]-b[0];});
        List<int[]>res = new ArrayList<>();
        int[]left = list.get(0);
        for(int i = 1;i<list.size();i++){
            int[]right = list.get(i);
            if(mergeable(left,right)){
                left = new int[]{left[0],Math.max(left[1],right[1])};

            }else{
                res.add(left);
                left = right;
            }

        }
        res.add(left);
        int[][]result = new int[res.size()][2];
        for(int i =0; i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;


    }
    private boolean mergeable(int[]a, int[]b){
        if(a[1]<b[0]){
            return false;
        };
        return true;

    }
}
