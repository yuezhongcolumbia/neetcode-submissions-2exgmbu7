class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        backtrack(n,k,path,res,1);
        return res;
    }

    public static void backtrack(int n, int k, List<Integer>path, List<List<Integer>>res, int curr){
        if(path.size() == k){
            List<Integer>copy = new ArrayList<>();
            for(int i:path){
                copy.add(i);
            }
            res.add(copy);
        }
        for(int i = curr;curr<=n;curr++){
            path.add(curr);
            backtrack(n,k,path,res,curr+1);
            path.remove(path.get(path.size()-1));
        }

    }


}