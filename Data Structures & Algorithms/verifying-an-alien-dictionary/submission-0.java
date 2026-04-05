class Solution {
    public boolean isAlienSorted(String[] words, String order) {
         int[] orderAlien = new int[26];
         for(int i =0; i < order.length(); i++){
            orderAlien[order.charAt(i)-'a']=i;
         }
         for(int i =0; i < words.length-1; i ++){
            String word1= words[i];
            String word2 = words[i+1];
            for(int j =0; j<word1.length();j++){
                if(j==word2.length()){
                    return false;
                }
                if(word1.charAt(j)!=word2.charAt(j)){
                        if(orderAlien[word1.charAt(j)-'a']>orderAlien[word2.charAt(j)-'a']){
                        return false;
                    }
                    break;
                }
                
            }


         }
         return true;
    }
}