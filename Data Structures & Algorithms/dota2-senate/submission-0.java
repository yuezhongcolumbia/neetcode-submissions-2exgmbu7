class Solution {
    public String predictPartyVictory(String senate) {
        List<Character> list = new ArrayList<>();
        char[] senateArray = senate.toCharArray();
        for (char c: senateArray){
            list.add(c);
        }
        while (true){
            int i = 0;
            while (i < list.size()){
                if (!list.contains('R')){
                    return "Dire";
                }
                if (!list.contains('D')){
                    return "Radiant";
                }
                if (list.get(i) == 'R'){
                    int j = (i + 1) % list.size();
                    while (list.get(j) == 'R'){
                        j = (j + 1) % list.size();
                    }
                    list.remove(j);
                    if (j < i){
                        i--;
                    }
                } else {
                    int j = (i + 1) % list.size();
                    while (list.get(j) == 'D'){
                        j = (j + 1) % list.size();
                    }
                    list.remove(j);
                    if (j < i){
                        i--;
                    }
                }
                i++;
            }
        }
    }
}