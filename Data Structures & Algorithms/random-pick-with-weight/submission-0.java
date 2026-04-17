class Solution {
    // 1. problem:
    //     1a. random choosing 
    //     2b. probability : w[i]/sum()
    // 2. for the probability to realize is to make the occurence probabilityof w[i] align
    //     with the probability we want
    //         [1,3] -> [1,3,3,3]
    //         [1,2,3] -> [1, 2, 2, 3,3,3], this is eazy, time will be O(1), space is the enormous
    //     2b.what ds to use to make this possible? to make an element more likely to be chosen?
    //         a voting system based on probability? 1: 1/4, 3: 3/4, 
    //         or a array large enough but not too large, with occurance of each weight follow said probability

    // 3. how to random choose? is there a function?
    // 4. give up after 24min

    
    // [1,3] -> [0, 1, 4]
    // target = 
    // binary search: we try to find left nearest index, return that element 
    // 总结： the reason why this represnent weight probability is because we are mapping the weight prob into 
    //         an interval space, the larger the number is, the bigger the interval is, the more likely it is 
    //         to be hit by total * random.
        
    int[] prefixSum;
    int[] w;

    public Solution(int[] w) {
        this.w = w;
        int n = w.length;
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + w[i];
        }
    }

    public int pickIndex() {
        double randomHit = prefixSum[w.length] * Math.random();
        int l = 0; int r = prefixSum.length - 1;
        int idx = -1 ;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (prefixSum[m] <= randomHit){
                idx = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */