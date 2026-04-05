class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String s: strs){
            result.append(s.length()).append('*').append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String>result = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='*'){
                j++;
            }
                int length = Integer.valueOf(str.substring(i,j));
                result.add(str.substring(j+1,j+length+1));
                i=j+1+length;
            }
        return result;
        }
        
    }

