class Solution {
    public int shortestWay(String source, String target) {
        // abcabc acac -> 1
        // abcabc aaacc -> 2
        // 1. The only way it return -1 is that target contains character that source doesnt have
        // 2. O(mn)is using two pointers:
        //     if (i == source.length()) res++, i = 0;
        //     if source.charAt(i) == source.charAt(j), i++, j++
        //     else i++;
        Set<Character> tarCharSet = new HashSet<>();
        for (char c: target.toCharArray()){
            tarCharSet.add(c);
        }
        for(char c: source.toCharArray()){
            if (tarCharSet.contains(c)){
                tarCharSet.remove(c);
            }
        }
        if (tarCharSet.size() > 0) return -1;
        int i = 0;
        int j = 0;
        int res = 1;
        while (j < target.length()){
            if (i == source.length()){
                res++;
                i = 0;
            }
            if (source.charAt(i) == target.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}
