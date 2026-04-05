class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer>set1= new HashSet<>();
        Set<Integer>set2 = new HashSet<>();
        for(int i =0;i<trust.length; i++){
            set1.add(trust[i][0]);
            set2.add(trust[i][1]);
        }
        if(set2.size()!=1 || !Collections.disjoint(set1,set2)|| set1.size()!=(n-1)){
            return -1;
        }
        int res = 0;
        for(int judge: set2){
            res = judge;
        }
        return res;
    }
}