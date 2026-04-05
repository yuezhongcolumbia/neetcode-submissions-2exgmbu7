class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //initialize
        Deque<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int l = 0; int r = 0;
        while (r < nums.length){
            //update the ds, which is the deque;
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            q.addLast(r);
            //update the left window
            if (l > q.getFirst()) {
                q.removeFirst();
            }
            //update the solution
            if (r >= k - 1){
                res.add(nums[q.getFirst()]);
                l++;
            }
            r++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
