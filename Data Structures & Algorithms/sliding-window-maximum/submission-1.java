class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //initiate deque
        Deque<Integer> dq = new LinkedList<>();
        int r = 0, l = 0;
        int[] res = new int[nums.length - k + 1];
        while (r < nums.length){
            while (!dq.isEmpty() && nums[r] > nums[dq.getLast()] ){
                dq.removeLast();
            }
            dq.addLast(r);
            
            //check if max is inbound
            if (l > dq.getFirst()){
                dq.removeFirst();
            }
            //update res
            if (r >= k - 1){
                res[l] = nums[dq.getFirst()];
                l++;
            }
            r++;

        }
        return res;
    }
}
