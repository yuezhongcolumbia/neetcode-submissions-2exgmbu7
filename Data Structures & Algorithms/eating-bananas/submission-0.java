class Solution {
    public int speed(int[]piles, int k){
        int res = 0;
        for(int p: piles){
            res += (p+k-1)/k;
        }
        return res;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        
        
        int l=1;
        int r= max;
        int result = 0;
        while(l<=r){
            int middle = (l+r)/2;
            int k = speed(piles,middle);
            
            if(k<=h){
                r = middle-1;
                result = middle;
            }else if(k>h){
                l = middle+1;
            }
        }
        return result;
        
    }
}
//binary search->need solve problem based on sorted array
//stuck: 1. didnt know how to convert problem into sorted array, I knew I have to use max value in input as a limit
//2. After watching the video, the code I wrote had bug
    
