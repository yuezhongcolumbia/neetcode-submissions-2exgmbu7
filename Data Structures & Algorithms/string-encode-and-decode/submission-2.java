class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for (String str: strs){
            sb.append(str.length()).append("#").append(str);
       }
       return new String(sb);
    }

    public List<String> decode(String str) {
        int left = 0;
        int right = 0;
        List<String> res = new ArrayList<>();
        while(left < str.length()){
            while(str.charAt(right) != '#'){
                right++;
            }
            int strLen = Integer.parseInt(str.substring(left, right));
            left = right + 1;
            right = left + strLen;
            res.add(str.substring(left, right));
            left = right;
        }
        return res;
    }
}
