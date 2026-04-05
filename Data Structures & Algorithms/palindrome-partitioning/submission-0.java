class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s,0,curr,res);
        return res;

    }

    public void backtrack(String s, int i,List<String>curr, List<List<String>>res){
        
       
        if(i==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j =i; j < s.length();j++){
            
            if(palindrome(s.substring(i,j+1))){
                curr.add(s.substring(i,j+1));
                backtrack(s, j+1,curr,res);
                curr.remove(curr.size()-1);
            }
            
        }





    }
    public boolean palindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)==(s.charAt(r))){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
