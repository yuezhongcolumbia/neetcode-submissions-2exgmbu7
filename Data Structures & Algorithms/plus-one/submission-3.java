class Solution {
    public int[] plusOne (int[] digits) {
        List<Integer>res = new ArrayList<>();
        int cur = (digits[digits.length-1]+1)%10;
        res.add(cur);
        int carry = (digits[digits.length-1]+1)/10;
        
        for(int i = digits.length-2;i>=0;i--){
            
           cur = (digits[i]+carry )%10;
            res.add(cur);
            carry = (digits[i]+carry )/10;
        }
        if(carry!=0){
            res.add(carry);
        }
        int[]result = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            result[i]= res.get(res.size()-1-i);
        }
        return result;

    }
}
