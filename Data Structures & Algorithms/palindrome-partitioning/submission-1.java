class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res = new ArrayList<>();
        List<String>path = new ArrayList<>();
        backtrack(s, path, res);
        return res;
    }

    private void backtrack(String str, List<String>path, List<List<String>>res){
        if(str.length()==0){
            List<String>copy = new ArrayList<>();
            for(String s: path){
                copy.add(s);
            }
            res.add(copy);
            return;
        }
        for(int i = 0; i<str.length();i++){
            String left = str.substring(0, i+1);
            String right = str.substring(i+1,str.length());
            if(isPalindrome(left)){
                path.add(left);
                backtrack(right,path,res);
                path.remove(path.size()-1);
            }

        }
        return;
    }
    
    
    private boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
